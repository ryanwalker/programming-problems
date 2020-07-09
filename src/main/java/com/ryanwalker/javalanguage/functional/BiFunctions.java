package com.ryanwalker.javalanguage.functional;

import com.ryanwalker.javalanguage.functional.model.Gender;
import com.ryanwalker.javalanguage.functional.model.Person;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public class BiFunctions {

  private static BiFunction<Integer, Gender, Person> person = (age, gender) -> new Person()
      .setAge(age)
      .setGender(gender);

//  private static ToIntBiFunction

  public static void main(String[] args) {
    System.out.println(person.apply(12, Gender.female));
  }

}
