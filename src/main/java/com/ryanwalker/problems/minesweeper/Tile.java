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

  public void display() {
    System.out.print(tileState.icon);
  }

  public enum TileState {
//    hidden("😁"),
    hidden("➖"),
    flagged("🚩"),
    empty(" "),
    exploded("❌"),
    showSurrounding(""),
    ;

    private final String icon;

    TileState(String icon) {
      this.icon = icon;
    }
  }



}
