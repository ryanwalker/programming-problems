package com.ryanwalker.problems.minesweeper;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * A 4x4 grid
 *
 * 1   2   3   4 5   6   7   8 9   10  11  12 13  14  15  16
 */
public class GameGrid {


  private Tile[][] grid;
  private int height;
  private int width;
  private int numberOfMines;
  private int totalTiles;
  private List<TileAddress> placedMines;

  private List<TileShift> shifts = Arrays.asList(
      TileShift.at(-1, -1),
      TileShift.at(-1, 0),
      TileShift.at(-1, 1),
      TileShift.at(0, -1),
      TileShift.at(0, 1),
      TileShift.at(1, -1),
      TileShift.at(1, 0),
      TileShift.at(1, 1)
  );

  public GameGrid(int height, int width, int numberOfMines) {
    this.height = height;
    this.width = width;
    this.grid = new Tile[height][width];
    this.totalTiles = height * width;

    this.numberOfMines = numberOfMines;
    this.placedMines = new LinkedList<>();

    initializeGrid();
  }

  private void initializeGrid() {
    Stack<Boolean> mineList = new Stack<>();
    while (totalTiles > 0) {
      if (this.numberOfMines > 0) {
        mineList.add(true);
        this.numberOfMines--;
      } else {
        mineList.add(false);
      }
      totalTiles--;
    }
    //Randomize the mineList
    Collections.shuffle(mineList);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Boolean mine = mineList.pop();
        if (mine) {
          placedMines.add(TileAddress.at(i, j));
        }
        Tile tile = new Tile(mine);
        grid[i][j] = tile;
        //Drop a tile in here
      }
    }

    //Loop through grid again, for empty tiles set the number of surrounding mines
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int numberOfSurroundingMines = getNumberOfSurroundingMines(new TileAddress(i, j));
        Tile tile = getTile(i, j);
        tile.setSurroundingMines(numberOfSurroundingMines);
      }
    }
  }

  private int getNumberOfSurroundingMines(TileAddress tileAddress) {
    int numberOfSurroundingMines = 0;
    for (TileShift shift : shifts) {
      int newRow = tileAddress.getRow() + shift.getRow();
      int newCol = tileAddress.getColumn() + shift.getCol();
      if (validTileAddress(newRow, newCol)) {
        Tile tile = getTile(newRow, newCol);
        if (tile.isMine()) {
          numberOfSurroundingMines++;
        }
      }
    }
    return numberOfSurroundingMines;
  }

  private boolean validTileAddress(int row, int col) {
    return row >= 0 && row < height && col >= 0 && col < width;
  }

  public Tile getTile(int row, int col) {
    return grid[row][col];
  }

  public void display() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Tile tile = getTile(i, j);
        tile.display();
        System.out.print("\t");
      }
      System.out.print("\n\n");
    }

  }


  //TODO - abstract out the for loop, functional programming?
  public void displayRevealedBoard() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Tile tile = getTile(i, j);
        if (tile.isMine()) {
          System.out.print("❌\t");
        } else {
          int surroundingMines = tile.getSurroundingMines();
          if (surroundingMines == 0) {
            System.out.print("➖\t");
          } else {
            System.out.print(numberEmoji(surroundingMines) + "\t");
          }
        }
      }
      System.out.println("\n");
    }
  }

  private String numberEmoji(int surroundingMines) {
    switch (surroundingMines) {
      case 0:
        return "⓪";
      case 1:
        return "①";
      case 2:
        return "②";
      case 3:
        return "③";
      case 4:
        return "④";
      case 5:
        return "⑤";
      case 6:
        return "⑥";
      case 7:
        return "⑦";
      case 8:
        return "⑧";
      default:
        return "♾️";
    }
  }

}
