package com.ryanwalker.sorting;

import static com.ryanwalker.TestUtil.printArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MergeSortTest {

  @Test
  public void testMergeSort1Item() {
    List<Integer> list = Arrays.asList(1);
    List<Integer> sortedList = MergeSort.sortList(list);

    Assertions.assertEquals(list, sortedList);
  }

  @Test
  public void testMergeSort2Items() {
    List<Integer> list = Arrays.asList(3, 1);
    List<Integer> sortedList = MergeSort.sortList(list);

    Assertions.assertEquals(Arrays.asList(1, 3), sortedList);
  }

  @Test
  public void testMergeSort2ItemsInOrder() {
    List<Integer> list = Arrays.asList(1, 3);
    List<Integer> sortedList = MergeSort.sortList(list);

    Assertions.assertEquals(Arrays.asList(1, 3), sortedList);
  }

  @Test
  public void testMergeSort3Item() {
    List<Integer> list = Arrays.asList(3, 1, 2);
    List<Integer> sortedList = MergeSort.sortList(list);

    Assertions.assertEquals(Arrays.asList(1, 2, 3), sortedList);
  }

  @Test
  public void testMergeSort4Item() {
    List<Integer> list = Arrays.asList(7, 3, 1, 2);
    List<Integer> sortedList = MergeSort.sortList(list);

    Assertions.assertEquals(Arrays.asList(1, 2, 3, 7), sortedList);
  }

  @Test
  public void testMergeSort10Item() {
    List<Integer> list = Arrays.asList(82, 3, 3, 1, 2, 99, 1, 8, 46);
    List<Integer> sortedList = MergeSort.sortList(list);

    Assertions.assertEquals(Arrays.asList(1, 1, 2, 3, 3, 8, 46, 82, 99), sortedList);
  }

  @Test
  public void testMergeSortArray() {
    int[] array = {3, 1};
    printArray(array);
    MergeSort.sortArray(array, 0, array.length - 1);
    printArray(array);
  }

  @Test
  public void testMergeSortArrayInOrder() {
    int[] array = {1, 3};
    printArray(array);
    MergeSort.sortArray(array, 0, array.length - 1);
    printArray(array);
  }

}