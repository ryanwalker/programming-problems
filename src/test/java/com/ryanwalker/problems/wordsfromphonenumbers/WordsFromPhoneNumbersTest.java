package com.ryanwalker.problems.wordsfromphonenumbers;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordsFromPhoneNumbersTest {

  @Test
  void wordsFromPhoneNumbers1() {

    WordsFromPhoneNumbers wordsFromPhoneNumbers = new WordsFromPhoneNumbers();

    final ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    List<String> words = wordsFromPhoneNumbers.wordsFromPhoneNumbers(numbers);

    Assertions.assertTrue(words.isEmpty());
    //    Assertions.assertEquals(Arrays.asList("a", "b", "c"), words);
  }

  @Test
  void wordsFromPhoneNumbers2() {

    WordsFromPhoneNumbers wordsFromPhoneNumbers = new WordsFromPhoneNumbers();

    final ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(2);
    List<String> words = wordsFromPhoneNumbers.wordsFromPhoneNumbers(numbers);

    Assertions.assertEquals(asList("a", "b", "c"), words);
  }

  @Test
  void wordsFromPhoneNumbers2And3() {

    WordsFromPhoneNumbers wordsFromPhoneNumbers = new WordsFromPhoneNumbers();

    final ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(2);
    numbers.add(3);
    List<String> words = wordsFromPhoneNumbers.wordsFromPhoneNumbers(numbers);

    Assertions.assertEquals(asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), words);
  }

  @Test
  void wordsFromPhoneNumbers2And3And4() {

    WordsFromPhoneNumbers wordsFromPhoneNumbers = new WordsFromPhoneNumbers();

    final ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    List<String> words = wordsFromPhoneNumbers.wordsFromPhoneNumbers(numbers);

    Assertions.assertEquals(asList(
        "adg", "adh", "adi",
        "aeg", "aeh", "aei",
        "afg", "afh", "afi",
        "bdg", "bdh", "bdi",
        "beg", "beh", "bei",
        "bfg", "bfh", "bfi",
        "cdg", "cdh", "cdi",
        "ceg", "ceh", "cei",
        "cfg", "cfh", "cfi"
    ), words);
  }
}