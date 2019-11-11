package com.ryanwalker.problems.kubracards;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {

  private Stack<Card> cardDeck;

  public CardDeck() {
    cardDeck = new Stack<>();
    for (CardSuit cardSuit : CardSuit.values()) {
      for (FaceValue faceValue: FaceValue.values()) {
        Card card = new Card(cardSuit, faceValue);
        cardDeck.push(card);
      }
    }
  }

  public void shuffle() {
    Collections.shuffle(cardDeck);
  }

  public void cut(int cutPoint) {
  }

  public Card deal() {
    return cardDeck.pop();
  }

  public Card turnOver() {
    return cardDeck.peek();
  }

  public void search(Card card) {
    int search = cardDeck.search(card);
  }

  public void newOrder() {

  }

}
