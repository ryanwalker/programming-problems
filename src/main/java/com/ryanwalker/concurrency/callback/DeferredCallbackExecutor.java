package com.ryanwalker.concurrency.callback;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


class Driver {

  public static void main(String[] args) throws InterruptedException {
    DeferredCallbackExecutor deferredCallbackExecutor = DeferredCallbackExecutor.create();
    Thread serviceThread = deferredCallbackExecutor.daemonStart();

//    example(deferredCallbackExecutor);

    tenThreads(deferredCallbackExecutor);

    Thread.sleep(20000);

    serviceThread.interrupt();
  }

  private static void example(DeferredCallbackExecutor deferredCallbackExecutor)
      throws InterruptedException {
    deferredCallbackExecutor.registerCallback(new Callback(8, "First Callback"));
    Thread.sleep(3000);
    deferredCallbackExecutor.registerCallback(new Callback(2, "Second Callback"));
  }

  private static void tenThreads(DeferredCallbackExecutor deferredCallbackExecutor) {
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          int waitSeconds = ThreadLocalRandom.current().nextInt(1, 11);
          deferredCallbackExecutor.registerCallback(
              new Callback(waitSeconds,
                  "I am thread: " + waitSeconds + " " + Thread.currentThread().getName()));
        }
      });
      thread.start();
    }
  }

}

class DeferredCallbackExecutor {

  private final ReentrantLock lock = new ReentrantLock();
  private final Condition newCallbackArrived = lock.newCondition();

  private final PriorityQueue<Callback> callbacksQueue = new PriorityQueue<>(
      Comparator.comparingLong(Callback::getExecuteAtMillis));

  private DeferredCallbackExecutor() {
  }

  public static DeferredCallbackExecutor create() {
    return new DeferredCallbackExecutor();
  }

  public Thread daemonStart() {
    Thread thread = new Thread(() -> {
      try {
        service();
      } catch (InterruptedException e) {
        System.out.println();
      }
    });
    System.out.println("Starting Daemon Thread...");
    thread.start();
    return thread;
  }

  private void service() throws InterruptedException {
    while (true) {
      lock.lock();

      // Wait while there are no callbacks
      while (callbacksQueue.isEmpty()) {
        newCallbackArrived.await();
      }

      // See if we need to sleep
      while (!callbacksQueue.isEmpty()) {
        Callback callback = callbacksQueue.peek();
        long sleepDuration = findSleepDuration(callback.getExecuteAtMillis());
        if (sleepDuration <= 0) {
          // Need to execute the next callback
          break;
        }
        newCallbackArrived.await(sleepDuration, TimeUnit.MILLISECONDS);
      }

      // If we're here, means we need to execute the next callback
      Callback callback = callbacksQueue.poll();
      callback.call();
      lock.unlock();
    }
  }

  public void registerCallback(Callback callback) {
    lock.lock();
    System.out.println("Registered callback...");
    callbacksQueue.add(callback);
    newCallbackArrived.signal();
    lock.unlock();
  }

  private long findSleepDuration(long executeAtMillis) {
    return executeAtMillis - System.currentTimeMillis();
  }
}
