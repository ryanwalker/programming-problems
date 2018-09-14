package com.ryanwalker.sorting;

public class InsertionSort {

  public static void sortArray(int[] numbers) {

    //nothing is technically sorted yet
    int sortedIndex = 0;
    int endIndex = numbers.length - 1;

    //Loop over each element
    for (int i = 0; i < numbers.length; i++) {
      if (sortedIndex <= endIndex) {
        //Element to insert somewhere
        int elementToInsert = numbers[sortedIndex];
        //Loop backwards
        // Copy elements until can insert
        for (int j = sortedIndex - 1; j >= 0; j--) {
          boolean copying = false;
          int candidateElement = numbers[j];
          if (elementToInsert < candidateElement) {
            //Copy number to the left
            numbers[j + 1] = candidateElement;
            copying = true;
            if (j == 0) {
              numbers[0] = elementToInsert;
            }
          } else if (copying){
            numbers[j] = elementToInsert;
          }
        }
      }
      sortedIndex++;
    }
    System.out.println("done");
  }
}
