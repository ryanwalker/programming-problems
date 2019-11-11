package com.ryanwalker.problems.regex;

public class SimpleifiedRegexMatching {


    public static void main(String[] args) {
        System.out.println(matches("hellloworld", "hel*.world"));
//        System.out.println(matches("hellloworldworld", "hel*o.world"));
    }


    /**
     * @param string
     * @param pattern - can be any of the following:
     * 1. a-z = itself
     * 2. . = any character
     * 3. * = matches 0 or more ocurrences of the previous
     * @return
     */
    static boolean matches(String string, String pattern) {
        // hel*o.*orld
        // helloworldworld
        // he - 0-1
        // l* - nothing or 2-3
        // o - 5
        // .* -   6-end
        // orld - no match
        //

        boolean matches = true;
        boolean iterate = true;
        int si = 0;
        int pi = 0;

        int stringLength = string.length();
        int patternLength = pattern.length();

        char currentStringChar = '$';
        char currentPatternChar = '$';

        char currentStarChar = '$';

        //iterate through string
        // Store currentStringChar and currentPatternChar
        // compare currentStringChar to currentPatternChar
        //  if a-z

        //  if '*'

        //  if '.' (do this later)

        while (matches && iterate) {
            //check for index out of bounds
            if (si < stringLength) {
                currentStringChar = string.charAt(si);
                si++;
            } else {
                iterate = false;
            }
            if (pi < patternLength && currentPatternChar !='*') {
                currentPatternChar = pattern.charAt(pi);
                pi++;
            } else {
                iterate = false;
            }

            if (currentPatternChar == '*') {
                if (currentStringChar != currentPatternChar) {
                    iterate = false;
                    matches = false;
                }
            } else if(currentPatternChar == '.') {
                // they match.
            } else { // it's a letter
                if (currentStringChar != currentPatternChar) {
                    iterate = false;
                    matches = false;
                }
            }

        }


        return matches;
    }


}
