package com.ryanwalker.javalanguage.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DiffeentFunctionalIinterfaces {


  public <T> Predicate<T> predicate(T resource) {
    return s -> s.equals("hi");
  }


  static class Contact {
    private String firstName;
    private String lastName;
  }



  public <T> Supplier<T> toSupplier() {
    return null;

  }

  public <T> Consumer<T> consumer() {
    return null;
  }

  public <T, R> Function<T, R> toFunction() {

    return null;
  }

}
