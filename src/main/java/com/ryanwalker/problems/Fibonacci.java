package com.ryanwalker.problems;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  public static void main(String[] args) {
    int num = fibonacci(100);
    System.out.println(num);
  }

  private static Map<Integer, Long> memo = new HashMap<>();

  private static int fibonacci(int i) {
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

      return fibonacci(i - 1) + fibonacci(i - 2);
    }
  }
}
