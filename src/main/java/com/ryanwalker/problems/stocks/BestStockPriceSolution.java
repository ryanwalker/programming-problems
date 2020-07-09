package com.ryanwalker.problems.stocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestStockPriceSolution {


  public static void main(String[] args) {
    List<Integer> stockPrices = Arrays.asList(5, 10, 3, 7);
    Integer profit = profit(stockPrices);
    System.out.println("The PROFIT: " + profit);
  }

  private static Integer profit(List<Integer> stockPrices) {
    if (stockPrices == null || stockPrices.size() == 0) {
      return 0;
    }
    Integer maxProfit = Integer.MIN_VALUE;
    Integer minPrice = stockPrices.get(0);

    for (int i = 1; i < stockPrices.size(); i++) {
      final Integer currentProfit = stockPrices.get(i) - minPrice;
      // find the maximum profit possible so far
      maxProfit = maxProfit > currentProfit ? maxProfit : currentProfit;
      // keep track of the lowest stock price seen so far
      minPrice = stockPrices.get(i) < minPrice ? stockPrices.get(i) : minPrice;
    }
    return maxProfit;
  }

}
