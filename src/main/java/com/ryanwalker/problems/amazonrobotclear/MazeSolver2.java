package com.ryanwalker.problems.amazonrobotclear;

/*
      0     1     2     3
  -------------------------
0  |  1  |  1  |  1  |  0  |
  -------------------------
1  |  1  |  0  |  1  |  1  |
  -------------------------
2  |  9  |  0  |  0  |  1  |
  -------------------------
3  |  1  |  1  |  1  |  1  |
  -------------------------

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolver2 {

  public static final int PATH = 1;
  public static final int WALL = 0;
  public static final int OBSTACLE = 9;

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
    RowCol root = new RowCol().setRow(0).setCol(0).setDepth(0);
    List<RowCol> processingQueue = new ArrayList<>();
    processingQueue.add(root);

    final Set<RowCol> visited = new HashSet<>();

    while (processingQueue.size() > 0) {
      RowCol rowCol = processingQueue.remove(0);
      visited.add(rowCol);
      int nodeValue = lot.get(rowCol.getRow()).get(rowCol.getCol());
      if (nodeValue == OBSTACLE) {
        return rowCol.getDepth();
      } else if (nodeValue == WALL) {
        //Don't do anything
      } else {
        //Get children and add them to list
        Set<RowCol> children = getChildren(rowCol.getRow(), rowCol.getCol(), numRows, numColumns,
            rowCol.getDepth() + 1, visited);
        processingQueue.addAll(children);
      }
    }

    return -1;
  }

  private Set<RowCol> getChildren(int row, int col, int numRows, int numCols, int depth, Set<RowCol> visited) {
    Set<RowCol> rowCols = new HashSet<>();

    RowCol up = new RowCol().setRow(row - 1).setCol(col).setDepth(depth);
    RowCol down = new RowCol().setRow(row + 1).setCol(col).setDepth(depth);
    RowCol left = new RowCol().setRow(row).setCol(col - 1).setDepth(depth);
    RowCol right = new RowCol().setRow(row).setCol(col + 1).setDepth(depth);

    validateAndAndRowCol(up, numRows, numCols, visited, rowCols);
    validateAndAndRowCol(down, numRows, numCols, visited, rowCols);
    validateAndAndRowCol(left, numRows, numCols, visited, rowCols);
    validateAndAndRowCol(right, numRows, numCols, visited, rowCols);

    return rowCols;
  }

  private void validateAndAndRowCol(RowCol rowCol, int numRows, int numCols, Set<RowCol> visited, Set<RowCol> rowCols) {
    //validate in grid
    if (rowCol.getRow() >= 0 && rowCol.getRow() < numRows &&
        rowCol.getCol() >= 0 && rowCol.getCol() < numCols
    ) {
      //Check visited
      if (!visited.contains(rowCol)) {
        rowCols.add(rowCol);
      }
    }
  }

  public static class RowCol {
    private int depth;
    private int row;
    private int col;

    public int getDepth() {
      return depth;
    }

    public RowCol setDepth(int depth) {
      this.depth = depth;
      return this;
    }

    public int getRow() {
      return row;
    }

    public RowCol setRow(int row) {
      this.row = row;
      return this;
    }

    public int getCol() {
      return col;
    }

    public RowCol setCol(int col) {
      this.col = col;
      return this;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      if (obj == this) {
        return true;
      }
      if (obj.getClass() != getClass()) {
        return false;
      }
      RowCol rhs = (RowCol) obj;

      return this.getRow() == rhs.getRow() &&
          this.getCol() == rhs.getCol();
    }

    @Override
    public int hashCode() {
      return this.getRow() * 31 + this.getCol();
    }
  }
}