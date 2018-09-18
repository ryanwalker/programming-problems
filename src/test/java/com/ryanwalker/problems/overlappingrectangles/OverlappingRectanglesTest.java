package com.ryanwalker.problems.overlappingrectangles;

import org.junit.jupiter.api.Test;

public class OverlappingRectanglesTest {

  @Test
  public void testAHigher() {
    OverlappingRectangles overlap = new OverlappingRectangles();

    Rectangle rectangleA = new Rectangle()
        .withCoordinate(0,3)
        .withCoordinate(0,1)
        .withCoordinate(2,3)
        .withCoordinate(2,1);

    Rectangle rectangleB = new Rectangle()
        .withCoordinate(1,2)
        .withCoordinate(1,0)
        .withCoordinate(3,2)
        .withCoordinate(3,0);


    overlap.coordinatesOfOverlap(rectangleA, rectangleB);
  }

//  @Test
  public void testBHigher() {
    OverlappingRectangles overlap = new OverlappingRectangles();

    Rectangle rectangleB = new Rectangle()
        .withCoordinate(0,3)
        .withCoordinate(0,1)
        .withCoordinate(2,3)
        .withCoordinate(2,1);

    Rectangle rectangleA = new Rectangle()
        .withCoordinate(1,2)
        .withCoordinate(1,0)
        .withCoordinate(3,2)
        .withCoordinate(3,0);


    overlap.coordinatesOfOverlap(rectangleA, rectangleB);
  }

  @Test
  public void testNoYOverlap() {
  }
}
