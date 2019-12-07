package com.ryanwalker.problems.minesweeper;

public class MinesweeperUserInterface {


  public void play(Game game) {
    switch (game.getGameStatus()) {
      case ready:
        start();
        break;
      case playing:
        playing(game);
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
    System.out.println("Easy:   1");
    System.out.println("Medium: 2");
    System.out.println("Hard:   3");
  }

  public void playing(Game game) {
    System.out.println("Please select a tile");
    System.out.println("\n");
    System.out.println("Uncover tile: u + tile address: u B4");
    System.out.println("Flag a  tile: f + tile address: f F7");
    System.out.println("Remove  flag: r + tile address: r D3");
    System.out.println();
    System.out.println("Start a new game: reset");
    System.out.println("Quit: quit");
    game.display();
  }

  public void gameOver() {

  }


  public void quit() {
    System.out.println("Thanks for playing Minesweeper!");
  }
}
