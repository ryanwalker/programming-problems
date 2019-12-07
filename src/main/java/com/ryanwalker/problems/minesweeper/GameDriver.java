package com.ryanwalker.problems.minesweeper;

import com.ryanwalker.problems.minesweeper.Game.Difficulty;
import com.ryanwalker.problems.minesweeper.Game.GameStatus;
import java.util.Scanner;

public class GameDriver {

  public static void main(String[] args) {
    MinesweeperUserInterface userInterface = new MinesweeperUserInterface();

    userInterface.welcome();

    Scanner scanner = new Scanner(System.in);
    Game game = new Game();

    boolean playing = true;
    try {
      while(playing) {
        //Display
        userInterface.play(game);

        //Read input
        String input = scanner.nextLine();

        //Process input
        game.acceptInput(input);

      }
    } catch (Exception e) {
      System.out.println(e);
    }

    userInterface.quit();

  }

}
