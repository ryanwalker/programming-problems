package com.ryanwalker.problems.overlappingrectangles;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
public class Rectangle {
  List<Coordinate> coordinates = new ArrayList<>();

  public Coordinate getMaxX() {
    return coordinates.stream()
        .max(Comparator.comparing(Coordinate::getX))
        .get();
  }

  public Coordinate getMaxY() {
    return coordinates.stream()
        .max(Comparator.comparing(Coordinate::getY))
        .get();
  }

  public Coordinate getMinX() {
    return coordinates.stream()
        .min(Comparator.comparing(Coordinate::getX))
        .get();
  }

  public Coordinate getMinY() {
    return coordinates.stream()
        .min(Comparator.comparing(Coordinate::getY))
        .get();
  }

  public Rectangle withCoordinate(int x, int y) {
    addCoordinate(new Coordinate(x, y));
    return this;
  }

  private void addCoordinate(Coordinate coordinate) {
    if (coordinates.size() < 4) {
      coordinates.add(coordinate);
    } else {
      throw new IllegalArgumentException("Rectangle cannot have more than 4 coordinates");
    }
  }
}
