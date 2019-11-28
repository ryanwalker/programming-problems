package com.ryanwalker.problems.minesweeper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TileAddress {

  private int row;
  private int column;

  public static TileAddress at(int row, int col) {
    return new TileAddress(row, col);
  }

}
