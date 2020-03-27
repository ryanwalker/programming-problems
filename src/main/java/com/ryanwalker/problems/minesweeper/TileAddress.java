package com.ryanwalker.problems.minesweeper;

public class TileAddress {

  private int row;
  private int column;

  public TileAddress(int row, int col) {
    this.row = row;
    this.column = col;
  }

  public static TileAddress at(int row, int col) {
    return new TileAddress(row, col);
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }
}
