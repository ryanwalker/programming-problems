package com.ryanwalker.concurrency.senderreceiver;

import static com.ryanwalker.concurrency.senderreceiver.Data.Status.RECEIVE;
import static com.ryanwalker.concurrency.senderreceiver.Data.Status.SEND;

public class Data {

  private String packet;
  Status status = Status.SEND;

  public synchronized void send(String packet) {
    while (status != Status.SEND) {
      try {
        System.out.println("Waiting for receiver...");
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Current thread interrupted");
      }
    }
    this.packet = packet;
    this.status = RECEIVE;
    notify();
  }

  public synchronized String receive() {
    while (status != RECEIVE) {
      try {
        System.out.println("Waiting for sender...");
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Current thread interrupted");
      }
    }
    String receivedData = packet;
    status = SEND;
    notify();
    return receivedData;
  }

  enum Status {
    SEND,
    RECEIVE
  }

}
