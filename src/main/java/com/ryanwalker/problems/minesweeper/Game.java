package com.ryanwalker.problems.minesweeper;

import java.util.Timer;
import lombok.Data;

public class Game {

  private Timer timer;
  private Difficulty difficulty;
  private GameGrid gameGrid;
  private int flags;

  public Game(Difficulty difficulty) {
    this.difficulty = difficulty;
    gameGrid = new GameGrid(difficulty.height, difficulty.width, difficulty.mines);
  }

  public void displayGrid() {
    gameGrid.display();
  }

  enum Difficulty {
    easy(8, 10, 10),
    medium(14,18, 40),
    difficult(20,24, 99);

    private int height, width, mines;

    Difficulty(int height, int width, int mines) {
      this.height = height;
      this.width = width;
      this.mines = mines;
    }
  }

}
