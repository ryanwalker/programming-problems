package com.ryanwalker.problems.minesweeper;

public class Tile {

  private TileState tileState;
  private int surroundingMines;
  private boolean mine;

  public Tile(boolean mine) {
    this.mine = mine;
    this.tileState = TileState.hidden;
  }

  public TileAddress tileAddress;

  public TileState getTileState() {
    return tileState;
  }

  public void setTileState(TileState tileState) {
    this.tileState = tileState;
  }

  public int getSurroundingMines() {
    return surroundingMines;
  }

  public void setSurroundingMines(int surroundingMines) {
    this.surroundingMines = surroundingMines;
  }

  public boolean isMine() {
    return mine;
  }

  public void setMine(boolean mine) {
    this.mine = mine;
  }

  public TileAddress getTileAddress() {
    return tileAddress;
  }

  public void setTileAddress(TileAddress tileAddress) {
    this.tileAddress = tileAddress;
  }

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
