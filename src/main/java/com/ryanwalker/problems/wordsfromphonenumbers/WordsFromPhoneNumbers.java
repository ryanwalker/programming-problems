package com.ryanwalker.problems.wordsfromphonenumbers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsFromPhoneNumbers {

  private final Map<Integer, List<String>> letters = new HashMap<>();

  public WordsFromPhoneNumbers() {
    letters.put(2, Arrays.asList("a", "b", "c"));
    letters.put(3, Arrays.asList("d", "e", "f"));
    letters.put(4, Arrays.asList("g", "h", "i"));
    letters.put(5, Arrays.asList("j", "k", "l"));
    letters.put(6, Arrays.asList("m", "n", "o"));
    letters.put(7, Arrays.asList("p", "q", "r", "s"));
    letters.put(8, Arrays.asList("t", "u", "v"));
    letters.put(9, Arrays.asList("w", "x", "y", "z"));
  }

  /**
   * Given a list of single digit numbers,
   * Return a list of all possible combinations of the letters associated with each number.
   *
   * Phone number pad:
   * | 1           | 2 (a,b,c) | 3 (d,e,f)   |
   * | 4 (g,h,i)   | 5 (j,k,l) | 6 (m,n,o)   |
   * | 7 (p,q,r,s) | 8 (t,u,v) | 6 (w,x,y,z) |
   *
   * Examples:
   * input: [2, 3]
   * output:
   * ad, ae, af
   * bd, be, bf
   * cd, cd, cf
   *
   * input: [3, 2]
   * output:
   * da, db, dc
   * ea, eb, ec
   * fa, fb, fc
   *
   * input: [2, 3, 4]
   */
  public List<String> wordsFromPhoneNumbers(List<Integer> numbers) {

    if (numbers.size() == 0) {
      return Collections.emptyList();
    }

    if (numbers.size() == 1) {
      List<String> let = letters.get(numbers.get(0));
      if (let == null) {
        return Collections.emptyList();
      }
      return let;
    }

    List<String> retVal = new ArrayList<>();

    int firstNumber = numbers.get(0);
    List<Integer> remainingNumbers = numbers.subList(1, numbers.size());

    List<String> firstLetters = letters.get(firstNumber);
    //Prepend this first letter to the beginning of the rest of the numbers
    for (String letter : firstLetters) {
      List<String> strings = wordsFromPhoneNumbers(remainingNumbers);
      List<String> collected = strings.stream()
          .map(s -> letter + s)
          .collect(Collectors.toList());
      retVal.addAll(collected);
    }

    return retVal;
  }
}
