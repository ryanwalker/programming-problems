package com.ryanwalker.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MergeSortTest {

  @Test
  public void testMergeSort1Item() {
    List<Integer> list = Arrays.asList(1);
    List<Integer> sortedList = MergeSort.sort(list);

    Assertions.assertEquals(list, sortedList);

  }

  @Test
  public void testMergeSort2Item() {
    List<Integer> list = Arrays.asList(3, 1);
    List<Integer> sortedList = MergeSort.sort(list);

    Assertions.assertEquals(Arrays.asList(1, 3), sortedList);
  }
}