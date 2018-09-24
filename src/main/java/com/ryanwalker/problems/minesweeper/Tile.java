package com.ryanwalker.problems.minesweeper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Tile {

  private boolean mine;
  private boolean visible;
  private int minesInSurroundingTiles;
  private int row;
  private int col;

}
