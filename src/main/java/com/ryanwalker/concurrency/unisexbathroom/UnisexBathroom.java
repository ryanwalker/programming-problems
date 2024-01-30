package com.ryanwalker.concurrency.unisexbathroom;

import com.ryanwalker.javalanguage.functional.model.Gender;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class UnisexBathroom {

  private Gender inUseBy;
  private int numInUse;

  private Semaphore inUseSemaphore = new Semaphore(3, true);


  public void useBathroom(Gender gender) throws InterruptedException {
    synchronized (this) {
      while(inUseBy == Gender.opposite(gender) || numInUse == 3) {
//        System.out.println(t() + gender + " waiting for bathroom");
        wait();
      }
      inUseSemaphore.acquire();
      inUseBy = gender;
      numInUse++;
    }

    System.out.println(gender + " is using the bathroom");
//    System.out.println("Available permits: " + inUseSemaphore.availablePermits());
    // Use bathroom
    Thread.sleep(5000);

    synchronized (this) {
      inUseSemaphore.release();
      numInUse--;
      if (numInUse == 0) {
        inUseBy = Gender.none;
      }
//      System.out.println(gender + " exited bathroom");
      notifyAll();
    }
  }

  private String t() {
    return Thread.currentThread().getName() + " ";
  }

}


class Driver {

  private static final UnisexBathroom bathroom = new UnisexBathroom();


  public static void main(String[] args) throws InterruptedException {
    List<Thread> threads = Arrays.asList(
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.female)),
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.female)),
        new Thread(useBathroom(Gender.male)),
        new Thread(useBathroom(Gender.female)),
        new Thread(useBathroom(Gender.female)),
        new Thread(useBathroom(Gender.male))
    );

    threads.forEach(Thread::start);

    for (Thread thread : threads) {
      thread.join();
    }

  }

  public static Runnable useBathroom(Gender gender) {
    return () -> {
      try {
        bathroom.useBathroom(gender);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };
  }
}
