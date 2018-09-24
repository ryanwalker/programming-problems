package com.ryanwalker.problems.minesweeper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameGridTest {


  /*
   * 1   2   3  4  5
   * 6   7   8  9  10
   * 11  12  13 14 15
   * 16  17  18 19 20
   */
  @Test
  public void testInit() {
    GameGrid grid = new GameGrid(5);

    Tile tileAtSeven = grid.getTileAtPosition(7);

    Assertions.assertEquals(2, tileAtSeven.getRow());
    Assertions.assertEquals(2, tileAtSeven.getCol());
  }
}
