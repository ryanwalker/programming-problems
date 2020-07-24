package com.ryanwalker.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();

//    int[] nums = {-1, 0, 1, 2, -1, -4};
//    int[] nums = {-1, 0, 1};
    int[] nums = {-1, -1, -1, 3, 3, 0, -2, -1, 1, 2, 1, 4, 8, 8, 6, 6, 7, 5, 3, 3, 3, 3, 3, 3, 3, 5};

//    List<List<Integer>> val = threeSum.twoSum(nums, 2);
    List<List<Integer>> val = threeSum.threeSum(nums);
    print(val);
  }

  // Loop through each number, calculate what 2 other numbers must equal
  // e.g. curVal = 3, then you need 2 numbers that add up to -3
  //
  // method to get list of lists of 2 numers adding up to some value

  public List<List<Integer>> threeSum(int[] nums) {
    // index the values:
    Map<Integer, Integer> numberIndex = createIndex(nums);
    
    // Loop through each key in the index, number, finding the twoSum values
    Set<List<Integer>> retVal = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      // Create array with current value removed
      int[] subArray = createSubArray(nums, i);
      List<List<Integer>> twoSums = twoSum(subArray, -1 * value);
      if (twoSums.size() > 0) {
        // add value to eac of the twoSum values them together
        for (List<Integer> twoSum : twoSums) {
          twoSum.add(value);
          Collections.sort(twoSum);
          retVal.add(twoSum);
        }
      }
    }
    return new ArrayList<>(retVal);
  }

  private Map<Integer, Integer> createIndex(int[] nums) {
    Map<Integer, Integer> index = new HashMap<>();
    for (int currentNumber : nums) {
      Integer numberCount = index.get(currentNumber);
      if (numberCount == null || numberCount == 0) {
        index.put(currentNumber, 1);
      } else {
        index.put(currentNumber, numberCount + 1);
      }
    }
    return index;
  }

  List<List<Integer>> twoSum(Map<Integer, Integer> nums, int sumTo) {
    Set<Integer> keys = nums.keySet();
    for (Integer currentNumber : keys) {
      //   2 =        4 - 2
      //  -3 =        4 - 7
      int requiredNumber = sumTo - currentNumber;
      if (requiredNumber == currentNumber) {
        // need to have 2+ values in index
      } else {
        // just need 1 value in index
      }
    }

  }

  private static void print(List<List<Integer>> val) {
    for (List<Integer> integers : val) {
      System.out.print("[ ");
      for (Integer integer : integers) {
        System.out.print(integer + ", ");
      }
      System.out.println(" ]");
    }
  }


}
