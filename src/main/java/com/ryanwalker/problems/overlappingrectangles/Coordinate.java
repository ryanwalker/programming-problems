package com.ryanwalker.problems.overlappingrectangles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Coordinate {
  private int x;
  private int y;

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
