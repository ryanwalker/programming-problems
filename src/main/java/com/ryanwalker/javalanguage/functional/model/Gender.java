package com.ryanwalker.javalanguage.functional.model;

public enum Gender {
  male, female, none;

  public static Gender opposite(Gender gender) {
    if (gender == male) {
      return female;
    }
    if (gender == female) {
      return male;
    }
    return none;
  }

}
