package com.ryanwalker.javalanguage.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Functional {

  /**
   * Output depends only on input Immutable No state changes No side effects
   */
  public int pureFunction(int a, int b) {
    return a + b;
  }


  private int val = 0;

  /**
   * Depends on state outside of function Side effect, it changes state outside
   */
  public int nonPureFunction(int a) {
    this.val += a;
    return this.val;
  }


  interface IFactory<T> {

    T create();
  }

  interface IProducer<T> {

    T produce();
  }

  interface IConfigurator<T> {

    T configure(T t);
  }

  class Factory implements IFactory<String> {

    @Override
    public String create() {
      return "Created String";
    }
  }

  class Producer implements IProducer<String> {

    @Override
    public String produce() {
      return "Produced String";
    }
  }

  class Configurator implements IConfigurator<String> {

    @Override
    public String configure(String s) {
      return "Configured String: " + s;
    }
  }


  /**
   * Higher order function meets one of following cases: 1. Takes function as param 2. Returns a
   * function
   */
  public <T> IFactory<T> createFactory(
      IProducer<T> producer,
      IConfigurator<T> configurator) {

    return () -> {
      T instance = producer.produce();
      T configured = configurator.configure(instance);
      return instance;
    };

  }

  private UnaryOperator<Integer> squareFunction = i -> i * i;


  public void unary() {

    List<Integer> squares = new ArrayList<>();

    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

    nums.forEach(it -> squares.add(squareFunction.apply(it)));

    List<Integer> retVal = nums.stream()
        .map(squareFunction)
        .collect(Collectors.toList());

  }

  public void biFunction() {

    BiFunction<Integer, String, String> biFunction = (string, num) -> string + ": " + num;

    List<String> keys = Arrays.asList("Key1", "Key2", "Key3");

    List<String> newKeys = new ArrayList<>();

    keys.forEach(key -> newKeys.add(biFunction.apply(1, key)));


  }


}
