package com.ryanwalker.concurrency.singleton;

// This double-checked locking pattern some consider anti-pattern
public class SingletonClassDeprecated {

  private static volatile SingletonClassDeprecated singleton;

  private SingletonClassDeprecated() {

  }

  public static SingletonClassDeprecated getInstance() {
    // Double checked locking.
    if (singleton == null) {
      synchronized (SingletonClassDeprecated.class) {

        if (singleton == null) {
          singleton = new SingletonClassDeprecated();
        }
      }
    }

    return singleton;
  }

  public void fly() {
    System.out.println("I am SingletonClass & I can fly !");
  }
}
