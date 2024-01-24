package com.ryanwalker.concurrency.senderreceiver;

public class Receiver implements Runnable {

  private Data data;

  public Receiver(Data data) {
    this.data = data;
  }

  @Override
  public void run() {
    String packet = data.receive();
    while (!"END".equals(packet)) {
      System.out.println("Received " + packet);
      packet = data.receive();
    }
  }
}
