package com.javaworld.leetcode;

public class P0309BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int hold = -prices[0];
        int sold = Integer.MIN_VALUE / 2;
        int rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int previousHold = hold;
            int previousSold = sold;
            hold = Math.max(previousHold, rest - prices[i]);
            sold = previousHold + prices[i];
            rest = Math.max(rest, previousSold);
        }
        return Math.max(sold, rest);
    }
}
