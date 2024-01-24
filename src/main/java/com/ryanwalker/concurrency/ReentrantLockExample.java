package com.ryanwalker.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

  private static final boolean FAIR = true;
  private static final ReentrantLock lock = new ReentrantLock(FAIR);
  private static final Condition condition1 = lock.newCondition();
  private static final Condition condition2 = lock.newCondition();

  public static void main(String[] args) throws InterruptedException {

    Thread thread1 = new Thread(ReentrantLockExample::executeThread1);
    Thread thread2 = new Thread(ReentrantLockExample::executeThread2);

    thread1.start();
    thread2.start();

    // Wait for threads to complete
    thread1.join();
    thread2.join();
  }

  public static void executeThread1() {
    lock.lock();

    try {
      condition1.await();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      lock.unlock();
    }
  }

  public static void executeThread2() {
    lock.lock();

    try {

    } finally {
      lock.unlock();
    }
  }


}
