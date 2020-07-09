package com.ryanwalker.javalanguage.functional.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Person {

  private Gender gender;
  private int age;

}
