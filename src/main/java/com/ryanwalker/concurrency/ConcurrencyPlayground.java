package com.ryanwalker.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ConcurrencyPlayground {
  private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
  private static Semaphore semaphore = new Semaphore(3);

  public static void main(String args[]) throws InterruptedException {
//    testCycliBarrier();
//    testSemaphore();

    System.out.println("Acquire semaphore main thread, 0 available.");
    new Semaphore(0).acquire();
    System.out.println("done");

  }

  private static void testSemaphore() {
    new Thread(sem(5000)).start();
    new Thread(sem(5000)).start();
    new Thread(sem(50000)).start();
    new Thread(sem(50000)).start();
    new Thread(sem(0)).start();
  }

  private static void testCycliBarrier() {
    new Thread(run(5000)).start();
    new Thread(run(5000)).start();
    new Thread(run(5000)).start();
    new Thread(run(0)).start();
  }

  private static Runnable sem(int millis) {

    return () -> {
      try {
        semaphore.acquire();
        System.out.println("Acquired semaphore, " + semaphore.availablePermits());
        Thread.sleep(millis);
        semaphore.release();
        System.out.println("released semaphore");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };


  }


  private static Runnable run(int millis) {
    return () -> {
      try {
        Thread.sleep(millis);
        System.out.println("Hit barrier");
        cyclicBarrier.await();
        System.out.println("off we go");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } catch (BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
    };
  }

}
