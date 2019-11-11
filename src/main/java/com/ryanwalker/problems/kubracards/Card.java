package com.ryanwalker.problems.kubracards;

import java.util.Comparator;

public class Card implements Comparator<Card> {

  private CardSuit suit;
  private FaceValue faceValue;

  public Card(CardSuit suit, FaceValue faceValue) {
    if (faceValue.getVal() < 1 || faceValue.getVal() > 13) {
      throw new IllegalArgumentException("Invalid card value");
    }
    this.suit = suit;
    this.faceValue = faceValue;
  }

  public String getFaceValue() {
    switch (faceValue) {
      case ace:
        return "ace";
      case jack:
        return "jack";
      case queen:
        return "queen";
      case king:
        return "king";
      default:
        return String.valueOf(faceValue);
    }
  }

  public String toString() {
    return getFaceValue() + " of " + suit;
  }

  @Override
  public int compare(Card firstCard, Card secondCard) {

    return 1;

  }
}
