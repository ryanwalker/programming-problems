package com.ryanwalker.problems.amazonrobotclear;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Down;
import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Left;
import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Right;
import static com.ryanwalker.problems.amazonrobotclear.MazeSolver.Direction.Up;

import java.util.ArrayList;
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

public class MazeSolver2 {
  int height;
  int width;

  Cell[][] grid;

  public MazeSolver2(int height, int width, List<List<Integer>> lot) {
    this.height = height;
    this.width = width;

    this.grid = new Cell[height][width];

    int ri = 0;
    int ci = 0;
    for (List<Integer> row : lot) {
      for (Integer val : row) {
        grid[ri][ci] = new Cell(val);
      }
      ri++;
      ci = 0;
    }
  }

  public static void main(String[] args) {
    List<Integer> row1 = Arrays.asList(1, 1, 1, 1);
    List<Integer> row2 = Arrays.asList(1, 0, 1, 0);
    List<Integer> row3 = Arrays.asList(0, 0, 1, 0);
    List<Integer> row4 = Arrays.asList(9, 1, 1, 1);

    //    MazeSolver2 sol = new MazeSolver2();

    //    int val = sol.removeObstacle(0,0, );
    //    System.out.println(val);
  }

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {

    //

    return 1;
  }
  // METHOD SIGNATURE ENDS

  enum Direction {
    Up,
    Down,
    Left,
    Right
  }

  public class Cell {
    boolean visited;
    int value;

    public Cell(Integer val) {
      this.value = val;
    }
  }
}