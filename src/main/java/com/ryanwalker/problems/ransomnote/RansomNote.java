package com.ryanwalker.problems.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

  public static boolean canMakeRansomeNote(String note, String magazine) {
    //Dump magazine into map
    Map<Character, Integer> charMap = preProcessMagazine(magazine);

    //Iterate over note, decrementing magazine letter count
    for (String letter : note.split("")) {
      Character character = letter.charAt(0);
      Integer count = charMap.get(character);
      if (count == 0) {
        return false;
      } else {
        count--;
        charMap.put(character, count);
      }

    }
    return true;
  }

  private static Map<Character, Integer> preProcessMagazine(String magazine) {
    //check empty or null magazin
    Map<Character, Integer> charMap = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++) {
      char letter = magazine.charAt(i);

      Integer count = charMap.get(letter);
      if (count == null) {
        charMap.put(letter, 1);
      } else {
        count++;
        charMap.put(letter, count);
      }

    }
    return charMap;
  }


}
