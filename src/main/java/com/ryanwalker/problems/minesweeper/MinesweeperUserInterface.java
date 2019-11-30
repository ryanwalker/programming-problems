package com.ryanwalker.problems.minesweeper;

import com.ryanwalker.problems.minesweeper.Game.GameStatus;

public class MinesweeperUserInterface {


  public void displayInstructions(GameStatus gameStatus) {
    switch (gameStatus) {
      case ready:
        start();
        break;
      case playing:
        playing();
        break;
      case won:
      case lost:
        gameOver();
        break;
      default:
        throw new RuntimeException("Bug, bad game state");
    }
  }

  public void welcome() {
    System.out.println("============================================");
    System.out.println("Welcome to Minesweeper");
    System.out.println("============================================");
  }


  public void start() {
    System.out.println("Please Select a Difficulty Level");
    System.out.println("1. Easy");
    System.out.println("2. Medium");
    System.out.println("3. Hard");
  }

  public void playing() {
    System.out.println("Please select a tile");
    System.out.println("Uncover tile: u + tile address: u B4");
    System.out.println("Flag a  tile: f + tile address: f F7");
    System.out.println("Remove  flat: r + tile address: r D3");
    System.out.println();
    System.out.println("Start a new game: reset");
  }

  public void gameOver() {

  }


}
