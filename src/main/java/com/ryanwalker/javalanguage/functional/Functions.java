package com.ryanwalker.javalanguage.functional;

import java.util.function.Function;

public class Functions {

  public static void main(String[] args) {

    Function<Integer, Integer> incrementAndMultiply = add1.andThen(times10);
    System.out.println(incrementAndMultiply.apply(14));

    System.out.println("--------------");

    System.out.println(add1.andThen(times10).andThen(square).apply(2));




    add1.compose(incrementAndMultiply);

  }

  static int increment(int number) {
    return number + 1;
  }

  static Function<Integer, Integer> add1 = num -> {
    System.out.println("add1");
    return ++num;
  };

  static Function<Integer, Integer> times10 = num -> {
    System.out.println("times10");
    return num * 10;
  };

  static Function<Integer, Integer> square = num -> {
    System.out.println("square");
    return num * num;
  };

}
