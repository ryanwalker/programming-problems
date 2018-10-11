package com.ryanwalker.problems.amazonrobotclear;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.*;
import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Down;
import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Left;
import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Right;
import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Up;

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
0  |  1  |  1  |  1  |  1  |
  -------------------------
1  |  1  |  0  |  1  |  0  |
  -------------------------
2  |  0  |  o  |  1  |  0  |
  -------------------------
3  |  0  |  1  |  9  |  1  |
  -------------------------





 */


public class MazeSolver {

  public static void main(String[] args) {
    List<Integer> row1 = Arrays.asList(1, 1, 1, 1);
    List<Integer> row2 = Arrays.asList(1, 0, 1, 0);
    List<Integer> row3 = Arrays.asList(0, 0, 1, 0);
    List<Integer> row4 = Arrays.asList(9, 1, 1, 1);

    MazeSolver sol = new MazeSolver();
    int val = sol.removeObstacle(4, 4, Arrays.asList(row1, row2, row3, row4));
    System.out.println(val);
  }

  int height;
  int width;

  int[][] grid = null;

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)

  {//now i see the input
    //Check if no 9s in list, return -1
    height = numRows;
    width = numColumns;
    grid = new int[numRows][numColumns];
    // WRITE YOUR CODE HERE
    // pseudo CODE
    // Write out a 2 dimensional array of the data
    int rowIndex = 0;
    int colIndex = 0;
    for (List<Integer> row : lot) {
      for (Integer val : row) {
        grid[rowIndex][colIndex] = val;
        colIndex++;
      }
      rowIndex++;
      colIndex = 0;
    }
    //Gonna hve to go to intellij to debu

    // write function and call it recursively to find the niminum Number
    // of spaces. This is a traversla problem
    int distToObstacle = distanceToObstacle(0, 0, 0, Direction.Start);

    return distToObstacle;
  }
  // METHOD SIGNATURE ENDS



  int distanceToObstacle(int row, int column, int currentDist, Direction direction) {

    //stop case is if i'm at the obstacle alreday
    //i'm assuming that if i'm opm top of the obstacle
    if (grid[row][column] == 9) {
      return currentDist;
    }

    //Try down
    if (canGo(Down, row, column, Up)) {
      return distanceToObstacle(row + 1, column, currentDist + 1, Direction.Up);
    }
    //Try right
    if (canGo(Right, row, column, Left)) {
      return distanceToObstacle(row, column + 1, currentDist + 1, Direction.Left);
    }
    //Try left
    if (canGo(Left, row, column, Right)) {
      return distanceToObstacle(row, column - 1, currentDist + 1, Direction.Right);
    }
    //Try up
    if (canGo(Up, row, column, Down)) {
      return distanceToObstacle(row - 1, column, currentDist + 1, Direction.Down);
    }
    //None work so set it to 0
    grid[row][column] = 0;
    return -1;
  }

  boolean canGo(Direction direction, int row, int col, Direction comingFrom) {
    switch (direction) {
      case Up:
        boolean canGoUp = comingFrom != Up && row > 0 && grid[row - 1][col] != 0;
        return canGoUp;
      case Down:
        boolean canGoDown = comingFrom != Down && row < height - 1 && grid[row + 1][col] != 0;
        return canGoDown;
      case Left:
        boolean canGoLeft = comingFrom != Left && col > 0 && grid[row][col - 1] != 0;
        return canGoLeft;
      case Right:
        boolean canGoRight = comingFrom != Right && col < width - 1 && grid[row][col + 1] != 0;
        return canGoRight;

    }
      return (row < height - 1 && grid[row + 1][col] != 0);
  }

  enum Direction {
    Start,
    Up, Down, Left, Right
  }

}