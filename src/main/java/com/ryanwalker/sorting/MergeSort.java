package com.ryanwalker.sorting;

import java.util.Arrays;
import java.util.List;

public class MergeSort {
  public static List<Integer> sort(List<Integer> list) {
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
        break;
    }

    return null;
  }
}
