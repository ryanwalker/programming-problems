package com.ryanwalker.concurrency.barbershop;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Barbershop {

  final int CHAIRS = 3;
  int waitingCustomers = 0;
  ReentrantLock lock = new ReentrantLock();
  Condition barberFree = lock.newCondition();
  Condition wakeUpBarber = lock.newCondition();
  boolean barberAsleep;


  void customerEnters() throws InterruptedException {
    lock.lock();
    if (waitingCustomers == CHAIRS) {
      System.out.println("Chairs full, customer leaves.");
      lock.unlock();
    }
    waitingCustomers++;

    lock.unlock();
  }

  void barber() throws InterruptedException {
    lock.lock();
    while (true) {
      if (waitingCustomers == 0) {
        barberAsleep = true;
        wakeUpBarber.await();
        barberAsleep = false;
        wakeUpBarber.signal();
      }

      lock.unlock();
    }
  }

}

enum CustomerState {
  wait, wakeBarber, gettingHairCut
}

enum BarberState {
  sleep, cutting,
}
