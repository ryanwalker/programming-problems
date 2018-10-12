package com.ryanwalker.problems.amazonrobotclear;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.Arrays;
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED

//This is not terribly clear to me. The input is basically a 2 dimensional Array
// that is full of 1 for flat, 0 for trench and 9 for the obsgaclole. Ok i think i got it
// actually. I thought the obstacle was multiple 9s but it's just a single 9.
// So i have to find the minimum distance to the obstqcle including the obstacle?
// or not ?? that's not clear exactly
//I"d solve this recursively with the time i have. Then probably convert it to
// dynamic programing.
//

/*

      0     1     2     3
  -------------------------
0  |  1  |  1  |  0  |  0  |
  -------------------------
1  |  0  |  1  |  1  |  1  |
  -------------------------
2  |  9  |  0  |  0  |  1  |
  -------------------------
3  |  1  |  1  |  1  |  1  |
  -------------------------

 */

public class MazeSolver2 {
  private static final int OBSTACLE = 9;
  private static final int TRENCH = 0;
  private static final int PATH = 1;
  private static final int VISITED = -7;

  int height;
  int width;

  int[][] visited;
  List<List<Integer>> theLot;

  public MazeSolver2() {
  }

  public static void main(String[] args) {
    List<Integer> row1 = Arrays.asList(1, 1, 0, 0);
    List<Integer> row2 = Arrays.asList(0, 1, 1, 1);
    List<Integer> row3 = Arrays.asList(9, 0, 0, 1);
    List<Integer> row4 = Arrays.asList(1, 1, 1, 1);

    List<List<Integer>> lot = Arrays.asList(row1, row2, row3, row4);

    MazeSolver2 solver = new MazeSolver2();

    int numberMoves = solver.removeObstacle(lot.size(), lot.get(0).size(), lot);
    System.out.println(numberMoves);
  }

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
    this.height = numRows;
    this.width = numColumns;
    this.theLot = lot;
    visited = new int[height][width];

    return explore(0, 0, 0);
  }

  int explore(int row, int col, int distanceTraveled) {
    Integer thingAtCurrentPosition = getValueAtLocation(row, col);
    if (thingAtCurrentPosition == OBSTACLE) {
      return distanceTraveled;
    }

    visited[row][col] = VISITED;

    Coordinate up = getCoordinate(Direction.Up, row, col);
    if (up != null) {
      int traveled = explore(up.row, up.column, ++distanceTraveled);
      if (traveled > -1) {
        return traveled;
      }
      distanceTraveled--;
    }

    Coordinate down = getCoordinate(Direction.Down, row, col);
    if (down != null) {
      int traveled = explore(down.row, down.column, ++distanceTraveled);
      if (traveled > -1) {
        return traveled;
      }
      distanceTraveled--;
    }

    Coordinate left = getCoordinate(Direction.Left, row, col);
    if (left != null) {
      int traveled = explore(left.row, left.column, ++distanceTraveled);
      if (traveled > -1) {
        return traveled;
      }
      distanceTraveled--;
    }

    Coordinate right = getCoordinate(Direction.Right, row, col);
    if (right != null) {
      int traveled = explore(right.row, right.column, ++distanceTraveled);
      if (traveled > -1) {
        return traveled;
      }
      distanceTraveled--;
    }
    distanceTraveled--;
    return -1;
  }

  private Coordinate getCoordinate(Direction direction, int currentRow, int currentCol) {
    //Return a coordinate only if
    //  1. In bounds
    //  2. Not a trench
    //  3. Haven't visited yet
    boolean inBounds = false;

    Coordinate newCoordinate = null;

    switch (direction) {
      case Up:
        newCoordinate = new Coordinate(currentRow - 1, currentCol);
        inBounds = newCoordinate.row >= 0;
        break;
      case Down:
        newCoordinate = new Coordinate(currentRow + 1, currentCol);
        inBounds = newCoordinate.row < height;
        break;
      case Left:
        newCoordinate = new Coordinate(currentRow, currentCol - 1);
        inBounds = newCoordinate.column >= 0;
        break;
      case Right:
        newCoordinate = new Coordinate(currentRow, currentCol + 1);
        inBounds = newCoordinate.column < width;
        break;
    }

    if (inBounds) {
      boolean isNotTrench = theLot.get(newCoordinate.row).get(newCoordinate.column) != TRENCH;
      boolean isNotVisited = visited[newCoordinate.row][newCoordinate.column] != VISITED;
      if (isNotTrench && isNotVisited) {
        return newCoordinate;
      }
    }

    return null;
  }

  private Integer getValueAtLocation(int row, int col) {
    return theLot.get(row).get(col);
  }
  // METHOD SIGNATURE ENDS

  public enum Direction {
    Up,
    Down,
    Left,
    Right
  }

  public class Coordinate {
    int row;
    int column;

    public Coordinate(int row, int column) {
      this.row = row;
      this.column = column;
    }

    public int getRow() {
      return row;
    }

    public Coordinate setRow(int row) {
      this.row = row;
      return this;
    }

    public int getColumn() {
      return column;
    }

    public Coordinate setColumn(int column) {
      this.column = column;
      return this;
    }
  }
}