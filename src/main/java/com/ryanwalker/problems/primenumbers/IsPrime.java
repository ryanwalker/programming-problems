package com.ryanwalker.problems.primenumbers;

public class IsPrime {

  public static void main(String[] args) {
    System.out.println("0 is prime: " + isPrime(0));
    System.out.println("1 is prime: " + isPrime(1));
    System.out.println("2 is prime: " + isPrime(2));
    System.out.println("5 is prime: " + isPrime(5));
    System.out.println("6 is prime: " + isPrime(6));
    System.out.println("8 is prime: " + isPrime(8));
    System.out.println("23 is prime: " + isPrime(23));
    System.out.println("51 is prime: " + isPrime(51));
    System.out.println("96 is prime: " + isPrime(96));
    System.out.println("97 is prime: " + isPrime(97));
    System.out.println("101 is prime: " + isPrime(101));
  }

  private static boolean isPrime(int num) {
    if (num == 1) {
      return false;
    }
    if (num == 2 || num == 3) {
      return true;
    }

    if (num % 2 == 0) {
      return false;
    }

    for (int i = 3; i < num / 2; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
