package com.ryanwalker.concurrency.senderreceiver;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {

  private Data data;

  public Sender(Data data) {
    this.data = data;
  }

  @Override
  public void run() {
    String packets[] = {
        "hello", "world", "how", "are", "you", "END"
    };
    for (String packet : packets) {
      System.out.println("Sending packet...");
      data.send(packet);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Current thread interrupted");
      }
    }
  }
}
