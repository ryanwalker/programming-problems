package com.ryanwalker.concurrency.callback;

import lombok.Getter;

public class Callback {

  @Getter
  private final long executeAtMillis;
  private final String message;

  public Callback(long waitSeconds, String message) {
    this.executeAtMillis = System.currentTimeMillis() + (waitSeconds * 1000);
    this.message = message;
  }

  public void call() {
    System.out.println(message);
  }

}
