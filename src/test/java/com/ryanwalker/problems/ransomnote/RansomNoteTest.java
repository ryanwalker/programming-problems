package com.ryanwalker.problems.ransomnote;

import static com.ryanwalker.problems.ransomnote.RansomNote.canMakeRansomeNote;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RansomNoteTest {

  @Test
  public void testRansomNote() {
    String note = "aabcdijllbbkkj";
    String magazine = "aabcdijkllbbkkijij";

    Assertions.assertTrue(canMakeRansomeNote(note, magazine));

  }

  @Test
  public void testRansomNoteFail() {
    String note = "aabbccdd";
    String magazine = "abcd";

    Assertions.assertTrue(canMakeRansomeNote(note, magazine));

  }

}