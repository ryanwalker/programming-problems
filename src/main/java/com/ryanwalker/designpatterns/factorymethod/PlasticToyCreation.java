package com.ryanwalker.designpatterns.factorymethod;

public class PlasticToyCreation {

}

interface Toy {
    void move();
}

class PlaneToy implements Toy {
  @Override
  public void move() {
    System.out.println("Flying");
  }
}

class CarToy implements Toy {
  @Override
  public void move() {
    System.out.println("Driving");
  }
}

abstract class ToyCreator {
  abstract Toy create();

}

class CarToyCreator extends ToyCreator {
  @Override
  Toy create() {
    return new CarToy();
  }
}

class PlaneToyCreator extends ToyCreator {
  @Override
  Toy create() {
    return new PlaneToy();
  }
}


class ToyFactory {
  static Toy create(String type) {
    return switch (type) {
      case "plane" -> new PlaneToy();
      default -> new CarToy();
    };
  }

}



class Driver {

  public static void main(String[] args) {
    // Simple Factory
    ToyFactory.create("plane").move();
    ToyFactory.create("car").move();


    // Factory method
    ToyCreator carCreator = new CarToyCreator();
    Toy car = carCreator.create();

    ToyCreator planeCreator = new PlaneToyCreator();
    Toy plane = planeCreator.create();

    car.move();
    plane.move();

    //Abstract Factory


  }
}
