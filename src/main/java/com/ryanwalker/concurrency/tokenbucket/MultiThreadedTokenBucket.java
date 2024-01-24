package com.ryanwalker.concurrency.tokenbucket;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public class MultiThreadedTokenBucket implements TokenBucketFilter{

  long capacity;
  long size;

  private final List<String> tokens; // FIFO
  private final Stack<String> tokensStack; // LIFO


  public MultiThreadedTokenBucket(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    tokens = new ArrayList<>();
    tokensStack = new Stack<>();
  }

  public synchronized void daemonThread() throws InterruptedException {
    while(true) {
      synchronized (this) {
        if (size != capacity - 1) {
          String token = UUID.randomUUID().toString();
          tokens.add(token);
          tokensStack.push(token);
          size++;
          notifyAll();
        }
      }

    }

  }

  public synchronized String getToken() throws InterruptedException {
    while (size == 0) {
      this.wait();
    }
    String token = tokens.get(0);
    String tokenFromStack = tokensStack.pop();

    System.out.println(size + " : " + token + " : " + tokenFromStack);

    Thread.sleep(10000);

    size--;
//    notifyAll();

    return token;
  }


  public static void main(String[] args) throws InterruptedException {
    MultiThreadedTokenBucket multiThreadedTokenBucket = new MultiThreadedTokenBucket(10);

    Thread thread = new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        System.out.println(i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
//        try {
//          multiThreadedTokenBucket.addToken(UUID.randomUUID().toString());
          System.out.println("Added token to bucket at " + System.currentTimeMillis());
//        } catch
      }
    });

    thread.start();

    Thread.sleep(20000);

    Thread getterThread = new Thread(() -> {
      while (true) {
        try {
          String token = multiThreadedTokenBucket.getToken();
          System.out.println("Thread got token " + token);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    getterThread.start();


  }

}
