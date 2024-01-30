package com.ryanwalker.concurrency.uberpoliticalride;

import static com.ryanwalker.concurrency.uberpoliticalride.PoliticalParty.democrat;
import static com.ryanwalker.concurrency.uberpoliticalride.PoliticalParty.republican;

class Demonstration {
  private static final UberPoliticalSeating uberPoliticalSeating = new UberPoliticalSeating();

  public static void main(String[] args) {

    enqueue(republican).start();
    enqueue(democrat).start();
    enqueue(democrat).start();
    enqueue(republican).start();

    enqueue(democrat).start();
    enqueue(republican).start();
    enqueue(republican).start();
    enqueue(democrat).start();

    enqueue(democrat).start();
    enqueue(democrat).start();
    enqueue(republican).start();
    enqueue(republican).start();
    enqueue(democrat).start();
    enqueue(democrat).start();
    enqueue(democrat).start();

  }

  public static Thread enqueue(PoliticalParty politicalParty) {
    return new Thread(() -> uberPoliticalSeating.getInLine(politicalParty));
  }


}

enum PoliticalParty {
  republican, democrat
}

public class UberPoliticalSeating {


  private int republicans = 0;
  private int democrats = 0;


  public synchronized void getInLine(PoliticalParty politicalParty) {
    incrementPartyCount(politicalParty);

    if (republicans >= 2 && democrats >= 2) {
      System.out.println("2 reps, 2 dems, off you go...");
      reducePartyCount(republican, 2);
      reducePartyCount(democrat, 2);
    } else if (partyCount(politicalParty) == 4) {
      System.out.println("4 " + politicalParty + ", off you go...");
      reducePartyCount(politicalParty, 3);
    }
    System.out.println("Republicans: " + republicans + ", Democrats: " + democrats);;
  }

  private void incrementPartyCount(PoliticalParty politicalParty) {
    if (politicalParty == republican) {
      republicans++;
    } else {
      democrats++;
    }
  }

  private void reducePartyCount(PoliticalParty politicalParty, int number) {
    if (politicalParty == republican) {
      republicans -= number;
    } else {
      democrats -= number;
    }
  }

  private int partyCount(PoliticalParty politicalParty) {
    if (politicalParty == republican) {
      return republicans;
    }
    return democrats;
  }


}
