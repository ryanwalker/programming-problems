package com.ryanwalker.problems.islandperimeter;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:


 */
public class IslandPerimeter {

  public static void main(String[] args) {
    Long start = System.currentTimeMillis();
    IslandPerimeter islandPerimeter = new IslandPerimeter();

    int[][] island =
        {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}};

    System.out.println(islandPerimeter.islandPerimeter(island));
    Long end = System.currentTimeMillis();
    System.out.println(end - start);
  }

  public int islandPerimeter(int[][] grid) {
    int perimeter = 0;

    // loop through grid, int[row][col]
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        System.out.println(grid[row][col]);
        boolean isLand = grid[row][col] == 1;
        if (isLand) {
          perimeter += borders(grid, row, col);
        }
      }
    }
    return perimeter;
  }

  private int borders(int[][] grid, int row, int col) {
    int borders = 0;
    // North if there's a preceding row
    if (row > 0) {
      borders += (grid[row - 1][col] == 0 ? 1 : 0);
    } else {
      borders += 1;
    }
    // South if there's another row
    if (row < grid.length - 1) {
      borders += (grid[row + 1][col] == 0 ? 1 : 0);
    } else {
      borders += 1;
    }
    // East
    if (col + 1 < grid[0].length) {
      borders += (grid[row][col + 1] == 0 ? 1 : 0);
    } else {
      borders += 1;
    }
    // West
    if (col > 0) {
      borders += (grid[row][col - 1] == 0 ? 1 : 0);
    } else {
      borders += 1;
    }

    return borders;
  }

}
