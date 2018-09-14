package com.ryanwalker.sorting;

import com.ryanwalker.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSortTest {

  @Test
  public void test() {

    int[] numbers = {3, 5, 9, 2, 1, 7, 3};

    BubbleSort.sortArray(numbers);

    int[] expectedNumbers = {1, 2, 3, 3, 5, 7, 9};

    Assertions.assertTrue(Arrays.equals(expectedNumbers, numbers));
    TestUtil.printArray(numbers);
  }
}
