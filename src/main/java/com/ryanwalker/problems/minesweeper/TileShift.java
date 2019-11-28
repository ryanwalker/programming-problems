package com.ryanwalker.problems.minesweeper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TileShift {
  int row, col;


  public static TileShift at(int row, int col) {
    return new TileShift(row, col);
  }
}
