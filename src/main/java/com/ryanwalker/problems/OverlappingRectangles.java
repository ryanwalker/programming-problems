package com.ryanwalker.problems;

import java.util.Comparator;
import java.util.stream.Stream;

public class OverlappingRectangles {

  public void overlappingArea(
      int ax1, int ay1,
      int ax2, int ay2,
      int ax3, int ay3,
      int ax4, int ay4,
      int bx1, int by1,
      int bx2, int by2,
      int bx3, int by3,
      int bx4, int by4
  ) {

    //See if there is overlap on y axis
    Integer ayMax = Stream.of(ay1, ay2, ay3, ay4)
        .max(Comparator.comparing(Integer::valueOf))
        .get();

    Integer ayMin = Stream.of(ay1, ay2, ay3, ay4)
        .min(Comparator.comparing(Integer::valueOf))
        .get();

    Integer byMax = Stream.of(by1, by2, by3, by4)
        .max(Comparator.comparing(Integer::valueOf))
        .get();

    Integer byMin = Stream.of(by1, by2, by3, by4)
        .min(Comparator.comparing(Integer::valueOf))
        .get();

    if (aHigherOrEqual(ayMax, byMax)) {
      if (aOverlapsB(ayMax, ayMin, byMax)) {
        System.out.println("A higher or equal: overlap in y direction");
        //height of overlap =
        int height = (ayMax - byMin)  - (ayMax - byMax) - (ayMin - byMin);
        System.out.println("height = " + height);
      } else {
        System.out.println("No overlap in y direction");
      }
    } else {
      //B is higher
      if (bOverlapsA(byMax, byMin, ayMax)) {
        System.out.println("B higher: overlap in y direction");
        int height = (byMax - ayMin)  - (byMax - ayMax) - (byMin - ayMin);
      } else {
        System.out.println("no overlap in y directions");
      }
    }
  }

  private boolean bOverlapsA(Integer byMax, Integer byMin, Integer ayMax) {
    return (ayMax <= byMax) && (ayMax > byMin);
  }

  private boolean aOverlapsB(int ayMax, int ayMin, int byMax) {
    return (byMax <= ayMax) && (byMax > ayMin);
  }

  private boolean aHigherOrEqual(Integer ayMax, Integer byMax) {
    return ayMax >= byMax;
  }
}
