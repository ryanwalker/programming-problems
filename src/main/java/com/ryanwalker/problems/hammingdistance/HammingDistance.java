package com.ryanwalker.problems.hammingdistance;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */

public class HammingDistance {
  public int hammingDistance(int x, int y) {
    int hammingDist = 0;
    String xString = Integer.toBinaryString(x);
    String yString = Integer.toBinaryString(y);
    System.out.println(xString);
    System.out.println(yString);
    int xIndex = xString.length() - 1;
    int yIndex = yString.length() - 1;
    int maxIndex = Math.max(xIndex, yIndex);
    for (int i = maxIndex; i >= 0; i--) {
      char xVal;
      char yVal;
      if (xIndex < 0) {
        xVal = '0';
        yVal = yString.charAt(yIndex);
      } else if (yIndex < 0) {
        yVal = '0';
        xVal = xString.charAt(xIndex);
      } else {
        xVal = xString.charAt(xIndex);
        yVal = yString.charAt(yIndex);
      }
      hammingDist += xVal != yVal ? 1 : 0;
      xIndex--;
      yIndex--;
    }
    // 0 0 1
    // 1 0 0
    return hammingDist;
  }


}
