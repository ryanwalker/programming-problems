package com.ryanwalker.problems;

import org.junit.jupiter.api.Test;

public class OverlappingRectanglesTest {

  @Test
  public void testAHigher() {
    OverlappingRectangles overlap = new OverlappingRectangles();
    overlap.overlappingArea(
        0, 3, 0, 1, 2, 3, 2, 1,
        1, 2, 1, 0, 3, 2, 3, 0
    );
  }

  @Test
  public void testNoYOverlap() {
    OverlappingRectangles overlap = new OverlappingRectangles();
    overlap.overlappingArea(
        0, 3, 0, 1, 2, 3, 2, 1,
        1, 1, 1, 0, 3, 1, 3, 0
    );
  }

  @Test
  public void testBHigher() {
    OverlappingRectangles overlap = new OverlappingRectangles();
    overlap.overlappingArea(
        1, 2, 1, 0, 3, 2, 3, 0,
        0, 3, 0, 1, 2, 3, 2, 1
    );
  }
}
