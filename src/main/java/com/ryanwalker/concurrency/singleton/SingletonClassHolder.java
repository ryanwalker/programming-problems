package com.ryanwalker.concurrency.singleton;

public class SingletonClassHolder {

  SingletonClassHolder() {
  }

  private static class Holder {

    static {
      System.out.println("Holder class loading...");
    }
    private static final SingletonClassHolder SINGLETON_CLASS_HOLDER = new SingletonClassHolder();
  }

  public static SingletonClassHolder get() {
    return Holder.SINGLETON_CLASS_HOLDER;
  }

}

class Driver {

  public static void main(String[] args) throws InterruptedException {
    SingletonClassHolder singletonClassHolder = new SingletonClassHolder();
    System.out.println("I am about to get the private static class...");
    Thread.sleep(10000);
    SingletonClassHolder.get();
  }
}
