package com.ryanwalker.concurrency.barrier;

// TODO - i didn't understand this one very well and moved on, revisit later.

public class ThreadBarrier {

  private int threadsAtBarrier;
  private int barrierSize;
  private int releasedThreads;

  public ThreadBarrier(int barrierSize) {
    this.barrierSize = barrierSize;
  }

  public synchronized void barrierWait() throws InterruptedException {

    while (threadsAtBarrier == barrierSize) {
      wait();
    }

    threadsAtBarrier++;

    if (threadsAtBarrier == barrierSize) {
      notifyAll();
      releasedThreads = barrierSize;
    } else {
      while (threadsAtBarrier < barrierSize) {
        wait();
      }
    }


    releasedThreads--;
    if (releasedThreads == 0) {
      threadsAtBarrier = 0;
      notifyAll();
    }

  }


}

class Driver {

  public static void main(String[] args) throws InterruptedException {
    ThreadBarrier threadBarrier = new ThreadBarrier(3);

    Thread t1 = new Thread(() -> {
      try {
        threadBarrier.barrierWait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    Thread t2 = new Thread(() -> {
      try {
        threadBarrier.barrierWait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });
    Thread t3 = new Thread(() -> {
      try {
        threadBarrier.barrierWait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    t1.start();
    t2.start();

    Thread.sleep(3000);

    t3.start();

    t1.join();
    t2.join();
    t3.join();

  }

}
