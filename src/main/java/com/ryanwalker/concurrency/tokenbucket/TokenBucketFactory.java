package com.ryanwalker.concurrency.tokenbucket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TokenBucketFactory {


  private TokenBucketFactory() {

  }

  public static MultiThreadedTokenBucket create(int capacity) {

    MultiThreadedTokenBucket tokenBucket = new MultiThreadedTokenBucket(5);

    Thread thread = new Thread(tokenBucket::daemon);

    thread.setDaemon(true);
    thread.start();
    return tokenBucket;

  }


  static class MultiThreadedTokenBucket implements TokenBucketFilter {

    private final int capacity;
    private final List<String> tokens;
    private int size = 0;


    public MultiThreadedTokenBucket(int capacity) {
      this.capacity = capacity;
      this.tokens = new ArrayList<>();
    }

    private void daemon() {
      while (true) {
        synchronized (this) {
          while (capacity == size) {
            try {
              wait();
            } catch (InterruptedException e) {
              // swallow
            }
          }

          String token = UUID.randomUUID().toString();
          tokens.add(token);
          size++;
          notify();
          System.out.println(size + ": Added " + token);
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // swallow
        }
      }

    }

    @Override
    public synchronized String getToken() throws InterruptedException {
      while (size == 0) {
        System.out.println(Thread.currentThread().getName() + " has to wait...");
        wait();
      }

      String token = tokens.removeFirst();
      size--;
      System.out.println("Thread " + Thread.currentThread().getName() + " got token " + token);
      notify();
      return token;
    }


  }

}
