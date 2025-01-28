package com.ryanwalker.problems;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {


  public static void main(String[] args) {
    System.out.println(fibonacciMemoized(17));
    System.out.println(fibonacciDynamic(17));
  }

  private static Map<Integer, Long> memo = new HashMap<>();

  private static int fibonacciMemoized(int i) {
    if (i == 0) {
      return 0;
    } else if (i == 1) {
      return 1;
    } else {
      Long iMinus2 = memo.get(i - 2);
      if (iMinus2 == null) {

      }
      Long iMinus1 = memo.get(i - 1);
      if (iMinus1 == null) {

      }

    }
  }


  private static int fibonacciDynamic(int f) {
    if (f == 0) {
      return 0;
    } else if (f == 1) {
      return 1;
    } else {
      // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
      int a = 0;
      int b = 1;
      int next = 0;
      for (int i = 2; i <= f; i++) {
        next = a + b;
        a = b;
        b = next;
      }
      return next;
    }
  }

}
