package com.ryanwalker.problems.minesweeper;

import java.util.LinkedList;
import java.util.List;

public class Game {

  private Difficulty difficulty;
  private GameGrid gameGrid;
  private int availbleFlags;
  private List<TileAddress> placedFlags;
  private GameStatus gameStatus;

  public Game(Difficulty difficulty) {
    this.difficulty = difficulty;
    initialize();
  }

  public void reset() {
    this.initialize();
  }

  public void initialize() {
    this.gameStatus = GameStatus.ready;
    this.placedFlags = new LinkedList<>();
    this.availbleFlags = difficulty.numberOfMines;

    this.gameGrid = new GameGrid(difficulty.height, difficulty.width, difficulty.numberOfMines);
  }

  public void display() {
    gameGrid.display();
  }

  public void reveal() {
    gameGrid.displayRevealedBoard();
  }

  enum Difficulty {
    easy(8, 10, 10),
    medium(14,18, 40),
    difficult(20,24, 99);

    private int height, width, numberOfMines;

    Difficulty(int height, int width, int numberOfMines) {
      this.height = height;
      this.width = width;
      this.numberOfMines = numberOfMines;
    }
  }

  enum GameStatus {
    ready,
    playing,
    lost,
    won
  }

}
