package com.ryanwalker.designpatterns.factorymethod;

public abstract class Vehicle {

  protected Engine engine;

  protected Vehicle makeVehicle() {
    engine = new CarEngine();
    return this;
  }

}

class Car extends Vehicle {
  @Override
  protected Vehicle makeVehicle() {
    super.makeVehicle();
    this.engine = new CarEngine();
    return this;
  }
}

class Plane extends Vehicle {
  @Override
  protected Vehicle makeVehicle() {
    super.makeVehicle();
    this.engine = new PlaneEngine();
    return this;
  }
}

interface Engine {
  String getType();
}

class CarEngine implements Engine {
  @Override
  public String getType() {
    return "Car";
  }
}

class PlaneEngine implements Engine {
  @Override
  public String getType() {
    return "Plane";
  }
}

