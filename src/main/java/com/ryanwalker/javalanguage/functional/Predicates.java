package com.ryanwalker.javalanguage.functional;

import com.ryanwalker.javalanguage.functional.model.Gender;
import com.ryanwalker.javalanguage.functional.model.Person;
import java.util.function.Predicate;

public class Predicates {


  public static void main(String[] args) {

    Predicate<Person> young = p -> p.getAge() < 18;
    Predicate<Person> male = p -> p.getGender() == Gender.male;

    Predicate<Person> youngMale = young.and(male);
    Predicate<Person> youngOrMale = young.or(male);

    Person seventeenYearOld = new Person().setAge(17);
    Person twentyYearOld = new Person().setAge(20);
  }



}
