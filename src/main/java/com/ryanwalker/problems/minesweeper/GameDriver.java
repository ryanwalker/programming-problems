package com.ryanwalker.problems.minesweeper;

import com.ryanwalker.problems.minesweeper.Game.Difficulty;
import java.util.Scanner;

public class GameDriver {

  public static void main(String[] args) {
    MinesweeperUserInterface userInterface = new MinesweeperUserInterface();

    userInterface.welcome();
    userInterface.start();

    userInterface.playing();

    Scanner scanner = new Scanner(System.in);


    Game game = new Game(Difficulty.easy);




    game.reveal();
    System.out.println("\n");
    game.display();







  }

}
