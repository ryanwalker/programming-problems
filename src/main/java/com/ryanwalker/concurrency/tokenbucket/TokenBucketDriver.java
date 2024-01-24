package com.ryanwalker.concurrency.tokenbucket;

public class TokenBucketDriver {

  public static void main(String[] args) throws InterruptedException {
    TokenBucketFactory.MultiThreadedTokenBucket multiThreadedTokenBucket =
        TokenBucketFactory.create(10);

    Thread.sleep(10000);

    Thread thread = new Thread(() -> {
      while (true) {
        try {
          multiThreadedTokenBucket.getToken();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      while (true) {
        try {
          multiThreadedTokenBucket.getToken();
        } catch (InterruptedException e) {
          //
        }
      }
    });

    Thread thread3 = new Thread(() -> {
      while (true) {
        try {
          multiThreadedTokenBucket.getToken();
        } catch (InterruptedException e) {
          //
        }
      }
    });


    thread2.start();
    thread.start();
    thread3.start();
    System.out.println("Started all 3 threads");


  }


}
