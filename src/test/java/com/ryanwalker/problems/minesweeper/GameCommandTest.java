package com.ryanwalker.problems.minesweeper;

import com.ryanwalker.problems.minesweeper.GameCommand.GameOperation;
import com.ryanwalker.problems.minesweeper.exception.IllegalGameCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameCommandTest {



  @Test
  public void testTileAddress_LeterNumber() throws IllegalGameCommandException {
    GameCommand command = new GameCommand("fa1");
    Assertions.assertEquals(0, command.getTileAddress().getRow());
    Assertions.assertEquals(0, command.getTileAddress().getColumn());
  }


  @Test
  public void testTileAddress_LetterLetterNumber() throws IllegalGameCommandException {
    GameCommand command = new GameCommand("faz33");
    Assertions.assertEquals(32, command.getTileAddress().getRow());
    Assertions.assertEquals(52, command.getTileAddress().getColumn());

  }

  @Test
  public void testTileAddress_LetterNumberNumber() {

  }


  @Test
  public void testFlag() throws IllegalGameCommandException {
    GameCommand command = new GameCommand("fa1");
    Assertions.assertEquals(GameOperation.flag, command.getOperation());
  }

  @Test
  public void testUncover() throws IllegalGameCommandException {
    GameCommand command = new GameCommand("sa1");
    Assertions.assertEquals(GameOperation.select, command.getOperation());
  }

  @Test
  public void testIllegalOperation() throws IllegalGameCommandException {
    Assertions.assertThrows(IllegalGameCommandException.class, () -> {
      GameCommand command = new GameCommand("ba1");
    });
  }

  @Test
  public void testIllegalColumn() throws IllegalGameCommandException {
    Assertions.assertThrows(IllegalGameCommandException.class, () -> {
      GameCommand command = new GameCommand("f-1");
    });
  }

  @Test
  public void testIllegalRow() throws IllegalGameCommandException {
    Assertions.assertThrows(IllegalGameCommandException.class, () -> {
      GameCommand command = new GameCommand("fz*");
    });
  }

}