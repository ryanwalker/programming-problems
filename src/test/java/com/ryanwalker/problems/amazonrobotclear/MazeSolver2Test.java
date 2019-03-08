package com.ryanwalker.problems.amazonrobotclear;

import static java.util.Arrays.asList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MazeSolver2Test {


  @Test
  public void test() {
    /*
      0     1     2     3
  -------------------------
0  |  1  |  1  |  1  |  0  |
  -------------------------
1  |  1  |  0  |  1  |  1  |
  -------------------------
2  |  9  |  0  |  0  |  1  |
  -------------------------
3  |  1  |  1  |  1  |  1  |
  -------------------------

 */

    List<List<Integer>> lot = asList(
        asList(1, 1, 1, 0),
        asList(1, 0, 1, 9),
        asList(9, 0, 0, 1),
        asList(1, 1, 1, 1)
    );

    MazeSolver2 mazeSolver2 = new MazeSolver2();

    int depth = mazeSolver2.removeObstacle(4, 4, lot);

    Assertions.assertEquals(2, depth);


  }


}