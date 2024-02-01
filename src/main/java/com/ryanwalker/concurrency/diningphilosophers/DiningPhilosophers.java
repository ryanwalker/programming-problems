package com.ryanwalker.concurrency.diningphilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class Driver {

  public static void main(String[] args) {
    DiningPhilosophers diningPhilosophers = new DiningPhilosophers(5);

    new Thread(() -> diningPhilosophers.live(1)).start();
    new Thread(() -> diningPhilosophers.live(2)).start();
    new Thread(() -> diningPhilosophers.live(3)).start();
    new Thread(() -> diningPhilosophers.live(4)).start();
    new Thread(() -> diningPhilosophers.live(5)).start();

  }

}

public class DiningPhilosophers {

  private final Semaphore[] forks;
  private final int numberOfPhilosophers;

  public DiningPhilosophers(int numberOfPhilosophers) {
    this.numberOfPhilosophers = numberOfPhilosophers;
    this.forks = new Semaphore[numberOfPhilosophers + 1];
    for (int i = 0; i < numberOfPhilosophers; i++) {
      Semaphore semaphore = new Semaphore(1);
      forks[i] = semaphore;
      // Same fork is in first and last spot
      if (i == numberOfPhilosophers - 1) {
        forks[i + 1] = semaphore;
        break;
      }
    }
  }


  public void live(int philosopher) {
    long startMillis = System.currentTimeMillis();
    while (true) {
      eat(philosopher);
      contemplate(philosopher);
      long nowMillis = System.currentTimeMillis();
      long aliveMillis = nowMillis - startMillis;
      if (aliveMillis > 20000) {
        System.out.println("Philosopher " + philosopher + " lived for " + aliveMillis + " millis");
        break;
      }
    }
  }


  public void eat(int philosopher) {
    boolean acquiredLeftFork = false;
    boolean acquiredRightFork = false;
    Semaphore leftForkSemaphore = forks[philosopher - 1];
    Semaphore rightForkSemaphore = forks[philosopher];
    try {
      acquiredLeftFork = leftForkSemaphore.tryAcquire(5, TimeUnit.SECONDS);
      if (acquiredLeftFork) {
        acquiredRightFork = rightForkSemaphore.tryAcquire(5, TimeUnit.SECONDS);
        if (acquiredRightFork) {
          System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ Philosopher " + philosopher + " ate");
        }
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      if (acquiredLeftFork) {
        leftForkSemaphore.release();
      }
      if (acquiredRightFork) {
        rightForkSemaphore.release();
      }
    }

  }

  public void contemplate(int philosopher) {
    int sleepSeconds = ThreadLocalRandom.current().nextInt(5);
    try {
      Thread.sleep(sleepSeconds * 1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted while contemplating");
    }
    System.out.println(
        "Philosopher " + philosopher + " contemplated for " + sleepSeconds + " seconds");
  }
}
