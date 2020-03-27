package com.ryanwalker.problems.overlappingrectangles;

public class Coordinate {
  private int x;
  private int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public Coordinate setX(int x) {
    this.x = x;
    return this;
  }

  public int getY() {
    return y;
  }

  public Coordinate setY(int y) {
    this.y = y;
    return this;
  }
}
