package com.ryanwalker.problems.squaresortedints;

public class SquareSortedInts {


  public static void main(String[] args) {
    SquareSortedInts algo = new SquareSortedInts();

    int[] array = {-3};
    int[] array2 = {-3, 0};
    int[] array3 = {-5, 0, 4};
    int[] array4 = {-2, -1, 0, 1};
    int[] array5 = {-99, -10, -9, -8, 7};
    int[] array6 = {-2, -1, 0, 1, 6, 7};

    algo.square(array);
    algo.square(array2);
    algo.square(array3);
    algo.square(array4);
    algo.square(array5);
    algo.square(array6);
  }


  /**
   * Given a sorted array of integers, return a sorted array of the square of each integer
   *
   *
   * @param - A sorted array of ints
   * @return
   */
  public int[] square(int[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }

    int[] returnArray = new int[array.length];

    int leftIndex = 0;
    int rightIndex = array.length - 1;

    int i = array.length - 1;
    while (i >= 0) {
      int leftValue = array[leftIndex];
      int rightValue = array[rightIndex];

      int leftValueSquared = leftValue * leftValue;
      int rightValueSquared = rightValue * rightValue;

      if (leftValueSquared >= rightValueSquared) {
        returnArray[i] = leftValueSquared;
        leftIndex++;
      } else {
        returnArray[i] = rightValueSquared;
        rightIndex--;
      }
      i--;
    }
    // Printing just for ease of debugging
    for (int i1 : returnArray) {
      System.out.print(i1 + ",");
    }
    System.out.println();

    return returnArray;
  }

}
