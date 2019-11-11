package com.ryanwalker.problems.kubracards;

import java.util.Comparator;

public enum CardSuit implements Comparator<CardSuit> {
  hearts, clubs, diamonds, spades;

  @Override
  public int compare(CardSuit first, CardSuit second) {
    return 0;
  }
}
