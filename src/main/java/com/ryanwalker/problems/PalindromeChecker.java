package com.ryanwalker.problems;

import java.util.Arrays;
import java.util.List;

public class PalindromeChecker {

  public static void main(String[] args) {

    List<String> potentialPalindromes = Arrays.asList("cow cat", "tacocat", "taco cat", "s", "aa", "aaa", "");

    for (String potentialPalindrome : potentialPalindromes) {
      System.out.println(isPalindrome(potentialPalindrome));
    }
  }

  public static String isPalindrome(String candidate) {
    if (candidate == null || candidate.length() == 0) {
      return "invalid string";
    }

    int beginCursor = 0;
    int endCursor = candidate.length() - 1;

    while (beginCursor < endCursor) {
      if (candidate.charAt(beginCursor) != candidate.charAt(endCursor)) {
        return candidate + " is NOT a palindrome";
      }
//TODO - solve whitespace bug
      beginCursor++;
      endCursor--;
    }
    return candidate + " IS a palindrome";
  }
}
