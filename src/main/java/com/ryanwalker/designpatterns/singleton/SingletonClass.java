package com.ryanwalker.designpatterns.singleton;

public class SingletonClass {

  SingletonClass() {
  }

  static {
    System.out.println("SingletonClass loaded...");
  }

  private static class Holder {

    static {
      System.out.println("Holder class loading...");
    }
    private static final SingletonClass SINGLETON_CLASS_HOLDER = new SingletonClass();
  }

  public static SingletonClass get() {
    return Holder.SINGLETON_CLASS_HOLDER;
  }

}

class Driver {

  public static void main(String[] args) throws InterruptedException {
    SingletonClass singletonClass = new SingletonClass();
    System.out.println("Instantiated SingletonClass, now sleep for 10s...");
    Thread.sleep(10000);
    SingletonClass.get();
  }

}
