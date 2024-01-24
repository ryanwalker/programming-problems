package com.ryanwalker.concurrency.blockingqueue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueSemaphore<T> {

  T[] array;
  int size = 0;
  int capacity;
  int head = 0;
  int tail = 0;
  private final Semaphore semaphore;

  public BlockingQueueSemaphore(int capacity) {
    this.capacity = capacity;
    array = (T[]) new Object[capacity];
    semaphore = new Semaphore(capacity);
  }

  public void enqueue(T item) throws InterruptedException {
    semaphore.acquire();
    synchronized (semaphore) {
      if (tail == capacity) {
        tail = 0;
      }

      array[tail] = item;
      size++;
      tail++;
    }
    semaphore.release();
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


}


