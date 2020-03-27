package com.ryanwalker.problems.minesweeper;

public class TileShift {
  int row, col;

  public TileShift(int row, int col) {
    this.row = row;
    this.col = col;
  }


  public static TileShift at(int row, int col) {
    return new TileShift(row, col);
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }
}
