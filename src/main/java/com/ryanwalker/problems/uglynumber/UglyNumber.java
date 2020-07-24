package com.ryanwalker.problems.uglynumber;

import java.util.ArrayList;
import java.util.List;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
 */

public class UglyNumber {
    public int nthUglyNumber(int n) {
      int uglyNumber = 1;
      List<Integer> list2 = new ArrayList<>(); list2.add(2);
      List<Integer> list3 = new ArrayList<>(); list3.add(3);
      List<Integer> list5 = new ArrayList<>(); list5.add(5);
      int count = 0;
      for (int i = 2; i <= n; i++) {
        uglyNumber = min(list2, list3, list5);
        list2.add(uglyNumber * 2);
        list3.add(uglyNumber * 3);
        list5.add(uglyNumber * 5);
      }
      return uglyNumber;
    }

    private int min(
        List<Integer> list2,
        List<Integer> list3,
        List<Integer> list5) {
      int factor2 = list2.get(0);
      int factor3 = list3.get(0);
      int factor5 = list5.get(0);

      int min = Math.min(Math.min(factor2, factor3), factor5);
      if (factor2 == min) {
        list2.remove(0);
      }
      if (factor3 == min) {
        list3.remove(0);
      }
      if (factor5 == min) {
        list5.remove(0);
      }
      return min;

  }
}
