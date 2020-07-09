package com.ryanwalker.problems.arraymanipulation;

public class PlusOne {

  public static void main(String[] args) {
    int[] input4 = {7, 2, 8, 9, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 0, 6, 9};
    print(input4);
    print(plusOne3(input4));

    int[] input3 = {9};
    print(input3);
    print(plusOne3(input3));

    int[] input2 = {4, 0, 6, 9};
    print(input2);
    print(plusOne3(input2));

    int[] input = {9, 9, 9};
    print(input);
    print(plusOne3(input));
  }

  private static void print(int[] ints) {
    for (int anInt : ints) {
      System.out.print(anInt + " ");
    }
    System.out.println();
  }

  public static int[] plusOne3(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int val = digits[i] + carry;
      if (val == 10) {
        carry = 1;
        digits[i] = 0;
      } else {
        carry = 0;
        digits[i] = val;
      }
    }
    if (digits[0] == 0) {
      // add 1 to beginning
      int[] newRetVal = new int[digits.length + 1];
      newRetVal[0] = 1;
      for (int i = 1; i < newRetVal.length; i++) {
        newRetVal[i] = digits[i-1];
      }
      return newRetVal;
    }
    return digits;
  }

  /*
  Iterate backwards
  current value =
  if LSB add 1
    if value == 10,
      set carryoer for next iteration
      set digit to 0
  if carryover add 1
    if value == 10
      set carryover for next iteration
      set digit to 0
  if MSB and value == 10
    Set digit to 0
    Add 1 to front of array
   */

  public static int[] plusOne2(int[] digits) {
    if (digits.length == 1 && digits[0] == 9) {
      int[] ret = {1, 0};
      return ret;
    }

    // iterate backwards adding
    boolean isLeastSignificant = false;
    boolean isMostSignificant = false;
    boolean needToCarryOver = false;
    boolean carryOver = false;
    boolean addOneToBeginning = false;

    for (int i = digits.length - 1; i >= 0; i--) {
      isLeastSignificant = i == digits.length - 1;
      isMostSignificant = i == 0;
      int currentValue = digits[i];
      int newValue = currentValue;

      if (isLeastSignificant) {
        // add 1
        newValue = ++currentValue;
        if (newValue == 10) {
          needToCarryOver = true;
          digits[i] = 0;
        } else {
          digits[i] = newValue;
        }
      }

      // if carryover add it
      if (carryOver) {
        newValue = ++currentValue;
        if (newValue == 10) {
          needToCarryOver = true;
          digits[i] = 0;
        } else {
          digits[i] = newValue;
        }
      }

      if (isMostSignificant && newValue == 10) {
        addOneToBeginning = true;
        digits[i] = 0;
      }

      // Check if we need to add 1 to the begining
      if (addOneToBeginning) {
        // add 1 to the beginning of the array
        int[] newRetVal = new int[digits.length + 1];
        // copy all the crap across, make better
        newRetVal[0] = 1;
        for (int j = 1; j < newRetVal.length; j++) {
          newRetVal[j] = digits[j - 1];
        }
        digits = newRetVal;
      }

      // Reset carryover
      carryOver = needToCarryOver;
      needToCarryOver = false;
    }
    return digits;
  }

}
