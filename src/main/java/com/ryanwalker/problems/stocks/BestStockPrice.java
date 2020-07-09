package com.ryanwalker.problems.stocks;

public class BestStockPrice {


  public static void main(String[] args) {

    int[] stocks1 = {8, 7, 4, 9, 2, 3, 5, 5, 12, 9, 4};
/**
 * buy, sell, profit
 * 8 7 = -1
 * 4 4 = -1
 *
 *
 *
 *
 *
  */


    System.out.println(bestGainN2(stocks1));

  }

  public static int bestGainN2(int[] stocks) {
    int bestGain = -1;
    for (int i = 0; i < stocks.length; i++) {
      for (int j = i + 1; j < stocks.length; j++) {
        int gain = stocks[j] - stocks[i];
        if (gain > bestGain) {
          bestGain = gain;
        }
      }
    }
    return bestGain;
  }

  public static int bestGain(int[] stocks) {
    int buyPrice = 0;
    int sellPrice = 0;
    int maxProfit = -1;

    // 1
    for (int i = 0; i < stocks.length-2; i++) {
      int curPrice = stocks[i];
      int nextPrice = stocks[i + 1];

      // 2
      if (nextPrice > curPrice) {
        buyPrice = curPrice;
        sellPrice = nextPrice;
        maxProfit = sellPrice - buyPrice;
      }
      if (curPrice < buyPrice) {
        buyPrice = curPrice;
      }

    }
    return maxProfit;
  }

}
