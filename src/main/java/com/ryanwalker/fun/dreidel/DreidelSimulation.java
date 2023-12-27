package com.ryanwalker.fun.dreidel;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class DreidelSimulation {

  private final List<String> DREIDEL_SYMBOLS = List.of("Get", "Half", "Share", "Nothing");
  private final int INITIAL_TOKEN_AMOUNT = 15;
  private int currentPlayer = 1;
  private final int numberOfPlayers;
  private int pot = 0;
  private int round = 1;
  private final Random random = new Random();
  private final Map<Integer, Integer> tokens = new HashMap<>();

  public DreidelSimulation(int numberOfPlayers) {
    if (numberOfPlayers < 2 || numberOfPlayers > 6) {
      throw new IllegalArgumentException("Number of players must be between 2 and 6");
    }

    this.numberOfPlayers = numberOfPlayers;

    // Setup tokens
    while (numberOfPlayers > 0) {
      tokens.put(numberOfPlayers, INITIAL_TOKEN_AMOUNT - 2);
      numberOfPlayers--;
      pot += 2;
    }
  }

  public void printCurrentState() {
    System.out.println("Pot: " + pot);
    tokens.forEach((player, tokenCount) ->
        System.out.println("Player " + player + ": " + tokenCount));
    System.out.println("\n");
  }

  public void playGame() {
    while (noWinner()) {
      spin();
    }
  }

  private boolean noWinner() {
    return tokens.values().stream()
        .filter(tokenCount -> tokenCount > 0
        ).count() > 1;
  }

  public void spin() {
    if (tokens.get(currentPlayer) == 0) {
      setPlayer();
      return;
    }
    System.out.println("Round " + round);
    System.out.println("Player " + currentPlayer + " is spinning the dreidel");
    String spin = DREIDEL_SYMBOLS.get(random.nextInt(4));
    switch (spin) {
      case "Get":
        System.out.println("Get: Player " + currentPlayer + " takes the pot, " + pot + " tokens");
        tokens.put(currentPlayer, tokens.get(currentPlayer) + pot);
        pot = 0;
        for (Entry<Integer, Integer> tokenEntries : tokens.entrySet()) {
          Integer player = tokenEntries.getKey();
          Integer playersTokens = tokenEntries.getValue();
          if (playersTokens == 0) {
            // do nothing
          } else if (playersTokens == 1) {
            tokens.put(player, 0);
            pot += 1;
          } else if (playersTokens == 2) {
            tokens.put(player, 0);
            pot += 2;
          } else {
            tokens.put(player, playersTokens - 2);
            pot += 2;
          }
        }
        break;
      case "Half":
        int halfPot = pot / 2;
        System.out.println(
            "Half: Player " + currentPlayer + " gets half the pot, " + halfPot + " tokens");
        pot -= halfPot;
        tokens.put(currentPlayer, tokens.get(currentPlayer) + halfPot);
        break;
      case "Share":
        int tokensAddedToPot;
        if (tokens.get(currentPlayer) == 1) {
          tokensAddedToPot = 1;
        } else {
          tokensAddedToPot = 2;
        }
        pot += tokensAddedToPot;
        tokens.put(currentPlayer, tokens.get(currentPlayer) - tokensAddedToPot);
        System.out.println(
            "Share: Player " + currentPlayer + " added " + tokensAddedToPot
                + " tokesn to the pot");
        break;
      case "Nothing":
        System.out.println("Nothing: Player " + currentPlayer + " gets nothing");
        break;
    }
    printCurrentState();
    setPlayer();
    checkGameState();
  }

  private void setPlayer() {
    int previousPlayer = currentPlayer;
    currentPlayer = (currentPlayer == numberOfPlayers ? 1 : currentPlayer + 1);
    if (previousPlayer > currentPlayer) {
      round++;
    }
  }

  private void checkGameState() {
    Preconditions.checkState(pot >= 0, "Pot must be 0 or greater");
    Preconditions.checkState(pot <= numberOfPlayers * INITIAL_TOKEN_AMOUNT, "Pot too big");
    int totalTokens = tokens.values().stream().reduce(Integer::sum)
        .orElseThrow(() -> new RuntimeException("oopsi")) + pot;
    Preconditions.checkState(totalTokens == numberOfPlayers * INITIAL_TOKEN_AMOUNT,
        "Too many tokens: " + totalTokens);
  }

  public static void main(String[] args) {
    DreidelSimulation dreidelSimulation = new DreidelSimulation(4);
    dreidelSimulation.playGame();
  }


}
