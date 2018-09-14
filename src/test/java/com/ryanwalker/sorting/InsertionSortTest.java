package com.ryanwalker.sorting;

import org.junit.jupiter.api.Test;

public class InsertionSortTest {

  @Test
  public void test() {
    int[] numbers = {6, 9, 1, 4};

    InsertionSort.sortArray(numbers);
  }
}
