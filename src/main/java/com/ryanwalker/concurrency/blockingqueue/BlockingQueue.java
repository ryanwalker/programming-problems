package com.ryanwalker.concurrency.blockingqueue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {

  T[] array;
  int size = 0;
  int capacity;
  int head = 0;
  int tail = 0;


  public BlockingQueue(int capacity) {
    this.capacity = capacity;
    array = (T[]) new Object[capacity];
  }

  public synchronized void enqueue(T item) throws InterruptedException {
    while (size == capacity) {
      this.wait();
    }

    if (tail == capacity) {
      tail = 0;
    }

    array[tail] = item;
    size++;
    tail++;

    this.notifyAll();
  }

  public synchronized T dequeue() throws InterruptedException {
    while (size == 0) {
      this.wait();
    }

    if (head == capacity) {
      head = 0;
    }

    T val = array[head];
    head++;
    size--;

    notifyAll();
    return val;
  }


  public void nono() throws InterruptedException {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // Thesee pause and signal only threads that are dealing with the specific condition.
    condition.await();
    condition.signalAll();

    // Same thread can acquire the lock multiple times.
    lock.lock();
    lock.lock();
  }

}


