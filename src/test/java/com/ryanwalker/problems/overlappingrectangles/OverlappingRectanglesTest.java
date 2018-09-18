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
  public void testNoOverlap() {
    OverlappingRectangles overlap = new OverlappingRectangles();

    Rectangle rectangleA = new Rectangle()
        .withCoordinate(1,3)
        .withCoordinate(1,4)
        .withCoordinate(4,3)
        .withCoordinate(4,4);

    Rectangle rectangleB = new Rectangle()
        .withCoordinate(2,1)
        .withCoordinate(2,2)
        .withCoordinate(3,1)
        .withCoordinate(3,2);

    overlap.coordinatesOfOverlap(rectangleA, rectangleB);

  }

  @Test
  public void testOverlap() {
    OverlappingRectangles overlap = new OverlappingRectangles();

    Rectangle rectangleA = new Rectangle()
        .withCoordinate(1,3)
        .withCoordinate(1,4)
        .withCoordinate(4,3)
        .withCoordinate(4,4);

    Rectangle rectangleB = new Rectangle()
        .withCoordinate(2,1)
        .withCoordinate(2,4)
        .withCoordinate(3,1)
        .withCoordinate(3,4);

    overlap.coordinatesOfOverlap(rectangleA, rectangleB);

  }

  @Test
  public void testCompleteOverlap() {
    OverlappingRectangles overlap = new OverlappingRectangles();

    Rectangle rectangleA = new Rectangle()
        .withCoordinate(1,1)
        .withCoordinate(1,3)
        .withCoordinate(3,1)
        .withCoordinate(3,3);

    Rectangle rectangleB = new Rectangle()
        .withCoordinate(2,1)
        .withCoordinate(2,2)
        .withCoordinate(3,1)
        .withCoordinate(3,2);

    Rectangle rectangle = overlap.coordinatesOfOverlap(rectangleA, rectangleB);
  }
}
