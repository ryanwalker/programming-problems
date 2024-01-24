package com.ryanwalker.concurrency.semaphore;

public class Semaphore {

  private int maxPermits;
  private int givenPermits = 0;

  public Semaphore(int permits) {
    this.maxPermits = permits;
  }

  public synchronized void acquire() throws InterruptedException {
    while (givenPermits == maxPermits) {
      System.out.println(Thread.currentThread().getName() + " waiting to acquire...");
      wait();
    }
    givenPermits++;
    System.out.println("Thread " + Thread.currentThread().getName() + " Acquired permit " + givenPermits);
    notifyAll();
  }

  public synchronized void release() throws InterruptedException {
    while (givenPermits == 0) {
      System.out.println(Thread.currentThread().getName() + " waiting to release...");
      wait();
    }
    givenPermits--;
    System.out.println("Thread " + Thread.currentThread().getName() + " Released permit " + givenPermits);
    notifyAll();
  }

}

class Driver {

  public static void main(String[] args) throws InterruptedException {
    Semaphore semaphore = new Semaphore(5);

    semaphore.acquire();
    semaphore.acquire();
    semaphore.acquire();
    semaphore.acquire();
    semaphore.acquire();

    Thread thread = new Thread(() -> {
      while (true) {
        try {
          System.out.println("Daemon sleep 1s...");
          Thread.sleep(1000);
          semaphore.acquire();
        } catch (InterruptedException e) {
          break;
        }
      }
    });

    thread.start();

    System.out.println("Main thread sleep 5...");
    Thread.sleep(5000);

    semaphore.release();
    semaphore.release();

    System.out.println("Interrupt Thread " + Thread.currentThread().getName());
    thread.interrupt();

    thread.join();

    System.out.println("ALL DONE!");
  }
}
