package com.ryanwalker.algorithms.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

  public static void main(String[] args) {
    int[][] array = {
        {0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 0},
        {0, 0, 1, 1, 0, 1, 1},
        {0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0},
        {1, 1, 1, 1, 0, 0, 0}
    };

    Grid grid = new Grid(array);
    System.out.println(grid.maxConnectedColors());

  }


  public static class Grid {

    int[][] grid;

    public Grid(int[][] grid) {
      this.grid = grid;
    }

    public int maxConnectedColors() {
      int maxConnected = 0;
      Map<String, Boolean> visited = new HashMap<>();
      //Search through the grid
      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[row].length; col++) {
          maxConnected = Math.max(maxConnected, dfs(row, col, visited));
        }
        return maxConnected;

      }
      return 0;
    }

    public int dfs(int row, int col, Map<String, Boolean> visited) {
      //Make key for visited map
      String key = row + "," + col;
      //If we've visited this one, return -
      if (visited.containsKey(key)) {
        return 0;
      }
      //Mark this spot as visited
      visited.put(key, true);
      //loop through neighbors and add dfs to result
      int result = 1;
      List<GridElement> neighbors = getNeighbors(row, col, grid[row][col]);
      for (GridElement neighbor : neighbors) {
        result += dfs(neighbor.row, neighbor.col, visited);
      }
      return result;
    }

    /**
     * Return neighbors of the same color
     */
    public List<GridElement> getNeighbors(int row, int col, int color) {
      List<GridElement> elements = new ArrayList<>();
      //up
      int r = row - 1;
      int c = col;
      if (r >= 0 && grid[r][c] == color) {
        elements.add(new GridElement(r, c));
      }

      //right
      r = row;
      c = col + 1;
      if (c < this.grid[0].length && grid[r][c] == color) {
        elements.add(new GridElement(r, c));
      }

      //down
      r = row + 1;
      c = col;
      if (r < this.grid.length && grid[r][c] == color) {
        elements.add(new GridElement(r, c));
      }

      //left
      r = row;
      c = col - 1;
      if (c >= 0 && grid[r][c] == color) {
        elements.add(new GridElement(r, c));
      }

      return elements;
    }
  }

  public static class GridElement {

    int row;
    int col;

    public GridElement(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

}
