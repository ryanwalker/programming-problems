package com.ryanwalker.sorting;

public class BubbleSort {

  public static void sortArray(int[] array) {

    int sortedIndexStart = array.length;

    for (int i = array.length - 1; i > 0; i--) {
      System.out.println(sortedIndexStart);
      for (int j = 0; j < sortedIndexStart; j++) {
        //Compare and swap
        int leftElement = array[j];
        //Check if we've hit the last index
        if (j + 1 < sortedIndexStart) {
          int rightElement = array[j + 1];

          if (leftElement > rightElement) {
            //swap
            array[j] = rightElement;
            array[j + 1] = leftElement;
          }
        }
      }
      sortedIndexStart--;
    }
  }
}
