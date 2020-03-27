package com.ryanwalker.problems.minesweeper;

import com.ryanwalker.problems.minesweeper.Tile.TileState;
import com.ryanwalker.problems.minesweeper.exception.IllegalGameCommandException;
import java.util.LinkedList;
import java.util.List;

public class Game {

  private Difficulty difficulty;
  private GameGrid gameGrid;
  private int availbleFlags;
  private List<TileAddress> placedFlags;
  private GameStatus gameStatus;


  public Game() {
    this.gameStatus = GameStatus.ready;
  }

  public void reset() {
    this.gameStatus = GameStatus.ready;
  }

  public void initialize() {
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

  public void acceptInput(String input) {
    if ("quit".equals(input)) {
      quit();
    }
    if ("reset".equals(input)) {
      reset();
    } else {
      switch (gameStatus) {
        case ready:
          Difficulty difficulty = Difficulty.parseDifficulty(input);
          setDifficulty(difficulty);
          initialize();
          setGameStatus(GameStatus.playing);
          break;
        case playing:
          // Parse tile selection command
          GameCommand command = null;
          try {
            command = new GameCommand(input);
          } catch (IllegalGameCommandException e) {
            //Bad command so break;
            break;
          }
          // process command
          apply(command);
          break;
        case won:
          break;
        case lost:
          break;
      }
    }
  }

  private void setGameStatus(GameStatus playing) {
    this.gameStatus = playing;
  }

  private void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  private void apply(GameCommand command) {
    switch (command.getOperation()) {
      case flag:
        //TODO - keep track of flags
        Tile tile = gameGrid
            .getTile(command.getTileAddress().getRow(), command.getTileAddress().getColumn());

        //TODO - Only allow flagging total number of mines
        //TODO - Only allow flagging hidden tiles
        if (tile.getTileState() == TileState.flagged) {
          tile.setTileState(TileState.hidden);
        } else {
          tile.setTileState(TileState.flagged);
        }

        break;
      case select:
        break;
    }
  }

  private void quit() {
    throw new RuntimeException("Quit");
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  enum Difficulty {
    easy(8, 10, 10),
    medium(14, 18, 40),
    hard(20, 24, 99);

    private int height, width, numberOfMines;

    Difficulty(int height, int width, int numberOfMines) {
      this.height = height;
      this.width = width;
      this.numberOfMines = numberOfMines;
    }

    public static Difficulty parseDifficulty(String input) {
      Difficulty difficulty = easy;
      if ("2".equals(input)) {
        difficulty = medium;
      }
      if ("3".equals(input)) {
        difficulty = hard;
      }
      return difficulty;
    }
  }

  enum GameStatus {
    ready,
    playing,
    lost,
    won,
  }

}
