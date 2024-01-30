package com.ryanwalker.concurrency.readwritelock;

public class ReadWriteLock {

  private int readers = 0;
  private boolean writeLocked;

  public synchronized void acquireReadLock() throws InterruptedException {
    while (writeLocked) {
      wait();
    }
    readers++;
    System.out.println(Thread.currentThread().getName() + " acquired Read Lock: " + readers);
  }

  public synchronized void releaseReadLock() {
    readers--;
    System.out.println(Thread.currentThread().getName() + " released Read Lock: " + readers);
  }

  public synchronized void acquireWriteLock() throws InterruptedException {
    while (writeLocked || readers != 0) {
      wait();
    }
    writeLocked = true;
    System.out.println(Thread.currentThread().getName() + "acquired Write Lock");
  }

  public synchronized void releaseWriteLock() {
    writeLocked = false;
    System.out.println(Thread.currentThread().getName() + " released Write Lock");
    notifyAll();
  }

}

class Driver {

  private static final ReadWriteLock readWriteLock = new ReadWriteLock();


  public static void main(String[] args) throws InterruptedException {

    readWriteLock.acquireWriteLock();

    Thread reader = new Thread(() -> {
        try {
          readWriteLock.acquireReadLock();
          Thread.sleep(1000);
          readWriteLock.releaseReadLock();
        } catch (InterruptedException e) {
          //
        }
    });

    Thread reader2 = new Thread(() -> {
      try {
        readWriteLock.acquireReadLock();
        Thread.sleep(2000);
        readWriteLock.releaseReadLock();
      } catch (InterruptedException e) {
        //
      }
    });

    reader.start();
    reader2.start();

    System.out.println("Main Thread Sleeping 3s");
    Thread.sleep(3000);

    readWriteLock.releaseWriteLock();

    reader.join();
    reader2.join();

  }

}
