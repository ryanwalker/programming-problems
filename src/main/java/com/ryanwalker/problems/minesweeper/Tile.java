package com.ryanwalker.problems.minesweeper;

import lombok.Data;

@Data
public class Tile {

  private TileState tileState;
  private int surroundingMines;
  private boolean mine;

  public Tile(boolean mine) {
    this.mine = mine;
    this.tileState = TileState.hidden;
  }

  public TileAddress tileAddress;

  public enum TileState {
    hidden,
    flagged,
    exposed,
  }



}
