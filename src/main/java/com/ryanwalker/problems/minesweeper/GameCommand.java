package com.ryanwalker.problems.minesweeper;

import com.ryanwalker.problems.minesweeper.exception.IllegalGameCommandException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class GameCommand {

  //ASCII a, subtract this to get 0 based column
  private static final int OFFSET = 97;
  private GameOperation operation;
  private TileAddress tileAddress;


  public static int getOFFSET() {
    return OFFSET;
  }

  public GameOperation getOperation() {
    return operation;
  }

  public void setOperation(GameOperation operation) {
    this.operation = operation;
  }

  public TileAddress getTileAddress() {
    return tileAddress;
  }

  public void setTileAddress(TileAddress tileAddress) {
    this.tileAddress = tileAddress;
  }

  public GameCommand(String gameCommand) throws IllegalGameCommandException {
    operation = parseOperation(gameCommand);
    tileAddress = parseTileAddress(gameCommand);
  }

  private GameOperation parseOperation(String commandString) throws IllegalGameCommandException {
    // Argument validation
//    Preconditions.checkNotNull(commandString);
//    Preconditions.checkArgument(commandString.length() >= 2, "command legnth too short");

    // Parse the command
    char commandChar = Character.toLowerCase(commandString.charAt(0));

    // Set command
    switch (commandChar) {
      case 's':
        return GameOperation.select;
      case 'f':
        return GameOperation.flag;
      default:
        throw new IllegalGameCommandException();
    }
  }

  private TileAddress parseTileAddress(String gameCommand) throws IllegalGameCommandException {
    if (gameCommand.length() < 3) {
      badCommand();
    }

    // Remove the operation
    String gridAddress = gameCommand.substring(1);
    if (gridAddress.length() == 2) {
      // pa1
      // letter digit
      char columnChar = gridAddress.charAt(0);
      char rowChar = gridAddress.charAt(1);

      boolean isLetter = Character.isLetter(columnChar);
      boolean isDigit = Character.isDigit(rowChar);

      if (isLetter && isDigit) {
//        return new TileAddress(parseRow(rowChar + ""), parseColumn(columnChar + ""));
      } else {
        badCommand();
      }
    } else if (gridAddress.length() == 3) {
      // paa1
      // pa12
      // letter letter digit
      // letter digit digit
      Pattern letterLetterNumberPattern = Pattern.compile("[a-z]{2}[1-9]");
      Matcher matcher1 = letterLetterNumberPattern.matcher(gridAddress);

      Pattern letterNumberNumber = Pattern.compile("[a-z][1-9]{2}");
      Matcher matcher2 = letterNumberNumber.matcher(gridAddress);

      String rowString = "";
      String colString = "";

      if (matcher1.find()) {
        colString = gridAddress.substring(0, 2);
        rowString = gridAddress.substring(2);
      } else if (matcher2.find()) {
        rowString = gridAddress.substring(0, 2);
        colString = gridAddress.substring(2);
      } else {
        badCommand();
      }
//      return new TileAddress(parseRow(rowString), parseColumn(colString));
    } else if (gridAddress.length() == 4) {
      // pzz52
      //letter letter digit digit
      boolean isLetter1 = Character.isLetter(gridAddress.charAt(0));
      boolean isLetter2 = Character.isLetter(gridAddress.charAt(1));
      boolean isDigit1 = Character.isDigit(gridAddress.charAt(2));
      boolean isDigit2 = Character.isDigit(gridAddress.charAt(3));
      if (isLetter1 && isLetter2 && isDigit1 && isDigit2) {
        String colString = gridAddress.substring(0, 2);
        String rowString = gridAddress.substring(2);
//        return new TileAddress(parseRow(rowString), parseColumn(colString));
      }
    }
    badCommand();
    return null;
  }

  private void badCommand() throws IllegalGameCommandException {
    throw new IllegalGameCommandException();
  }

  private int parseRow(String tileGridNumber) {
    return Integer.parseInt(tileGridNumber) - 1;
  }

  private int parseColumn(String tileGridNumber) throws IllegalGameCommandException {
    //Assume it's lowercase
    if (tileGridNumber.length() == 1) {
      int letter = tileGridNumber.charAt(0);
      return letter - OFFSET;
    } else if (tileGridNumber.length() == 2) {
      int firstLetter = tileGridNumber.charAt(0);
      firstLetter = firstLetter - 96;
      int secondLetter = tileGridNumber.charAt(1);
      secondLetter = secondLetter - 96;

      int col = 26 * firstLetter + secondLetter;
      return col;
    }
    throw new IllegalGameCommandException();
  }

  enum GameOperation {
    select,
    flag,
  }

}
