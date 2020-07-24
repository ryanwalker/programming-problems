package com.ryanwalker.problems.prisoncells;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)



Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation:
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]


Note:

cells.length == 8
cells[i] is in {0, 1}
1 <= N <= 10^9

 */
public class PrisonCells {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] cells = {1, 0, 0, 1, 0, 0, 1, 0};
//    print(solution.prisonAfterNDays(cells, 1000000000));
    print(solution.prisonAfterNDays(cells, 30));
    System.out.println("EXPECTED: [0,0,1,1,1,1,1,0]");
  }

  static void print(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  static class Solution {
//TODO - GROSSSS!
    public int[] prisonAfterNDays(int[] cells, int N) {

      int[] day1Cells = new int[8];
      for (int i = 1; i < 7; i++) {
        day1Cells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
      }
      int cycle = 0;
      int daysLeft = 0;

      System.out.print("DAY 0:\t");
      print(cells);
      int dayNumber = 1;
      while (dayNumber <= N) {
        System.out.print("DAY " + dayNumber + ":\t");
        int[] newCells = new int[8];
        for (int j = 1; j < 7; j++) {
          newCells[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
        }
        print(newCells);

        if (dayNumber > 1 && Arrays.equals(newCells, day1Cells)) {
          // Remove the rest of the cycles
          cycle = dayNumber - 1;
          daysLeft = (N % cycle);// already did next row
          System.out.println("CYCLE: " + cycle + ", DAYS LEFT: " + daysLeft);
          break;
        }
        cells = newCells;
        dayNumber++;
      }
      if (cycle > 0) {
        for( int i = 1; i <= daysLeft; i++) {
          int[] newCells = new int[8];
          for (int j = 1; j < 7; j++) {
            newCells[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
          }
          cells = newCells;
        }
      }
      return cells;
    }

    /*
      N=20;
      Day 15;
      Cycle = 14;
      daysLeft = 20 % 14 == 6 - 1
      N % cycle == 6

      N - 5


     */

    public int[] prisonAfterNDays2(int[] cells, int N) {

      int cycle = 1;
      int[] first = new int[8];

      // Calculate Day1
      for (int i = 1; i < 7; i++) {
        first[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
      }
      N -= 1;

      cells = Arrays.copyOf(first, 8);

      while (N-- > 0) {

        int[] temp = new int[8];

        for (int i = 1; i < 7; i++) {
          temp[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
        }

        if (Arrays.equals(temp, first)) {
          System.out.println("CYCLE AT: " + N);
          ;
          N %= cycle;
        }

        for (int i = 0; i < 8; i++) {
          cells[i] = temp[i];
        }

        cycle++;
      }

      return cells;


    }
  }
}
