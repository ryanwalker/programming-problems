package com.ryanwalker.problems.recursive;

class MathSequence {

  public static void main(String[] args) {

    for (int i = 0; i <= 50; i++) {
      System.out.println(i + ": " + numberSequenceMemoized(i));
    }

    for (int i = 0; i <= 50; i++) {
      System.out.println(i + ": " + numberSequence(i));
    }
  }

  /**
   * Compute n given the following formula:
   * f(n) = f(n - 2) + f(n - 3) * 3
   * f(0) = 1
   * f(1) = 2
   * f(3) = f(1) + f(0) * 3
   */
  public int formulaValue(int n) {


    return -1;
  }


  public static long numberSequence(int n) {
    if (n < 0) {
      return -100;
    }

    if (n == 0) {
      return -2;
    }

    if (n == 1) {
      return 1;
    }

    return numberSequence(n - 1) + numberSequence(n - 2) + 3;
  }

  public static long numberSequenceMemoized(int n) {
    long[] memo = new long[n + 1];

    return numberSequenceMemoized(n, memo);
  }

  private static long numberSequenceMemoized(int n, long[] memo) {
    switch (n) {
      case 0:
        return -2;
      case 1:
        return 1;
    }

    if (memo[n] > 0) {
      return memo[n];
    } else {

      long n1 = memo[n - 1];
      if (n1 == 0) {
        n1 = numberSequenceMemoized(n - 1, memo);
        memo[n - 1] = n1;
      }

      long n2 = memo[n - 2];
      if (n2 == 0) {
        n2 = numberSequenceMemoized(n - 2, memo);
        memo[n - 2] = n2;
      }

      long nn = n1 + n2 + 3;
      memo[n] = nn;
      return nn;
    }
  }
}



