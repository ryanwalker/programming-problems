package com.ryanwalker.problems.kubracards;

public enum FaceValue {

  ace(1),
  two(2),
  three(3),
  four(4),
  five(5),
  six(6),
  seven(7),
  eight(8),
  nine(9),
  ten(10),
  jack(11),
  queen(12),
  king(13);

  private int val;

  FaceValue(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }
}
