package com.ryanwalker.problems.minesweeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * A 4x4 grid
 *
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 13  14  15  16
 */
public class GameGrid {

  public static void main(String[] args) {
    GameGrid grid = new GameGrid(5);
  }

  private Tile[][] grid;
  private int height;

  public GameGrid(int height) {
    // [row][column]
    this.height = height;
    this.grid = new Tile[height][height];

    int numOfMines = 10;

    initializeGrid(10);
  }

  private void initializeGrid(int mines) {
    int totalTiles = height * height;
    Stack<Boolean> mineList = new Stack<>();
    while (totalTiles > 0) {
      if (mines > 0) {
        mineList.add(true);
        mines--;
      } else {
        mineList.add(false);
      }
      totalTiles--;
    }
    Collections.shuffle(mineList);


    for (int i = 0; i < height; i++) {
      for (int j = 0; j < height; j++) {
        grid[i][j] = new Tile(false, mineList.pop(), false);
        //Drop a tile in here
      }
    }

    System.out.printf("blah");
  }

  public Tile getTile(int row, int col) {
    return grid[row][col];
  }
}
