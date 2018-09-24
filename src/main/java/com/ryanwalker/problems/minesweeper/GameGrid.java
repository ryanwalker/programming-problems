package com.ryanwalker.problems.minesweeper;

import java.math.BigDecimal;

/**
 * A 4x4 grid is numbered like this
 *
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 */
public class GameGrid {

  private Tile[][] grid;
  private int width;

  public GameGrid(int width) {
    // [row][column]
    this.width = width;
    this.grid = new Tile[width][width];

    initializeGrid();
  }

  private void initializeGrid() {
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < width; j++) {
        grid[i][j] = Tile.builder()
            .row(i + 1)
            .col(j + 1)
            .build();
      }
    }
  }

  public Tile getTileAtPosition(int tileNumber) {
    int row = tileNumber / width + 1;
    int col = 0;

    if (tileNumber % width > 0) {
      row--;
    }

    // 2.75
    BigDecimal num = BigDecimal.valueOf(tileNumber / Double.valueOf(width));

    // 2
    int integerPart = num.intValue();

    // 0.75
    BigDecimal fractionPart = num.remainder(BigDecimal.ONE);

    if (fractionPart.equals(0)) {
      col = width - 1;
    } else {
      col = (fractionPart.multiply(BigDecimal.valueOf(width))
          .subtract(new BigDecimal(1))).intValue();
    }

    return grid[row][col];
  }
}
