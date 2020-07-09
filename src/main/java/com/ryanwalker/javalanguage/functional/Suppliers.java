package com.ryanwalker.javalanguage.functional;

import com.ryanwalker.javalanguage.functional.model.Gender;
import com.ryanwalker.javalanguage.functional.model.Person;
import java.util.function.Supplier;

public class Suppliers {


  static Supplier<Person> personSupplier = () -> new Person().setAge(1).setGender(Gender.male);

  public static void main(String[] args) {

  }


}
