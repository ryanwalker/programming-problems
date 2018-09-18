package com.ryanwalker.problems.overlappingrectangles;

import java.util.Arrays;
import java.util.List;

public class OverlappingRectangles {

  public Rectangle coordinatesOfOverlap(Rectangle a, Rectangle b) {

    int aMaxY = a.getMaxY().getY();
    int aMinY = a.getMinY().getY();

    int bMaxY = b.getMaxY().getY();
    int bMinY = b.getMinY().getY();

    List<Integer> yCoordinates = getCoordinates(aMaxY, aMinY,  bMaxY, bMinY);

    int aMaxX = a.getMaxX().getX();
    int aMinX = a.getMinX().getX();

    int bMaxX = b.getMaxX().getX();
    int bMinX = b.getMinX().getX();

    List<Integer> xCoordinates = getCoordinates(aMaxX, aMinX, bMaxX, bMinX);

    Rectangle rect = new Rectangle()
        .withCoordinate(xCoordinates.get(0), yCoordinates.get(0))
        .withCoordinate(xCoordinates.get(0), yCoordinates.get(1))
        .withCoordinate(xCoordinates.get(1), yCoordinates.get(0))
        .withCoordinate(xCoordinates.get(1), yCoordinates.get(1));

    return rect;
  }

  private List<Integer> getCoordinates(int aMax, int aMin, int bMax, int bMin) {
    boolean aHigherOrEqual = aMax >= bMax;
    if (aHigherOrEqual) {
      boolean aOverlaps = (bMax <= aMax) && (bMax > aMin);
      if (aOverlaps) {

        int high = bMax;
        int low = Math.max(aMin, bMin);
        return Arrays.asList(high, low);
      }

    } else {
      //B is higher
      boolean bOverlaps = aMax <= bMax && aMax > bMin;
      if (bOverlaps) {
        int xHigh = aMax;
        int xLow = Math.max(bMin, aMin);
        return Arrays.asList(xHigh, xLow);
      }

    }
    return Arrays.asList();
  }

}
