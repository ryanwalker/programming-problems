package com.ryanwalker.problems.minesweeper;

import com.ryanwalker.problems.minesweeper.Game.Difficulty;

public class GameDriver {

  public static void main(String[] args) {
    Game game = new Game(Difficulty.easy);

    game.reveal();
    System.out.println("\n");
    game.display();






  }

}