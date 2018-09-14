package com.ryanwalker.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
  public static List<Integer> sortList(List<Integer> list) {
    int listSize = list.size();

    switch (listSize) {
      case 0:
      case 1:
        return list;
      case 2:
        Integer first = list.get(0);
        Integer second = list.get(1);
        if (first > second) {
          return Arrays.asList(second, first);
        } else {
          return list;
        }
      default:
        //Split the list into two
        int endIndex = list.size() - 1;
        int middleIndex = (listSize / 2) + (listSize % 2);
        List<Integer> leftList = list.subList(0, middleIndex);
        List<Integer> rightList = list.subList(middleIndex, listSize);

        //recursive call to sort left and right list
        List<Integer> sortedLeft = sortList(leftList);
        List<Integer> sortedRight = sortList(rightList);

        //merge them back together
        List<Integer> mergedList = merge(sortedLeft, sortedRight);
        return mergedList;
    }
  }

  private static List<Integer> merge(List<Integer> sortedLeft, List<Integer> sortedRight) {
    List<Integer> mergedList = new ArrayList<>();
    int totalElements = sortedLeft.size() + sortedRight.size();

    int leftIndex = 0;
    int leftEndIndex = sortedLeft.size();
    int rightIndex = 0;
    int rightEndIndex = sortedRight.size();

    while (totalElements > 0) {
      Integer leftVal = null;
      Integer rightVal = null;
      if (leftIndex < leftEndIndex) {
        leftVal = sortedLeft.get(leftIndex);
      }
      if (rightIndex < rightEndIndex) {
        rightVal = sortedRight.get(rightIndex);
      }

      if (leftVal != null && rightVal != null) {
        if (leftVal > rightVal) {
          mergedList.add(rightVal);
          rightIndex++;
        } else {
          mergedList.add(leftVal);
          leftIndex++;
        }
      } else if (rightVal == null) {
        mergedList.add(leftVal);
        leftIndex++;
      } else {
        mergedList.add(rightVal);
        rightIndex++;
      }
      totalElements--;
    }
    return mergedList;
  }

  public static void sortArray(int[] array, int leftIndex, int rightIndex) {
    if (array.length == 0 || array.length == 1) {
      return;
    }

    if (array.length == 2) {
      if (array[0] > array[1]) {
        int larger = array[0];
        array[0] = array[1];
        array[1] = larger;
      }
      return;
    }

    //Split the list into two
    int middleIndex = (rightIndex - leftIndex) / 2;

    //recursive call to sort left and right list
    if (leftIndex != rightIndex) {
      sortArray(array, leftIndex, middleIndex);
      sortArray(array, middleIndex + 1, rightIndex);
    }

    //merge them back together
    mergeArrays(array, leftIndex, middleIndex, rightIndex);
  }

  private static void mergeArrays(int[] array, int leftIndex, int middleIndex, int rightIndex) {
    //left array = leftIndex -> middleIndex, inclusive
    //right array = middlIndex + 1 -> rightIndex, inclusive

    int totalElement = rightIndex - leftIndex + 1;

    if (totalElement == 1) {
      return;
    } else if (totalElement == 2) {
      if (array[leftIndex] > array[rightIndex]) {
        swap(array, leftIndex, rightIndex);
      }
      return;
    } else {
      while (totalElement > 0) {
        boolean validLeftElement = (leftIndex <= middleIndex);
        boolean validRightElement = rightIndex < array.length;

        if (validLeftElement && validRightElement) {
          int leftElement = array[leftIndex];
          int rightElement = array[rightIndex];
          if (leftElement > rightElement) {
            swap(array, leftIndex, rightIndex);
            leftElement++;
          }
        } else if (validLeftElement) {

        } else {

        }

//        if (leftElement > rightElement) {
//          array[leftIndex] = rightElement;
//          array[rightIndex] = leftElement;
//          leftIndex++;
//        } else {
//          rightIndex++;
//        }
//        totalElement++;
      }
    }
  }

  private static void swap(int[] array, int leftIndex, int rightIndex) {
    int leftElement = array[leftIndex];
    int rightElement = array[rightIndex];

    array[leftIndex] = rightElement;
    array[rightIndex] = leftElement;
  }
}
