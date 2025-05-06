package com.javaworld.leetcode;

import java.util.Arrays;

public class P0322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minimum = new int[amount + 1];
        Arrays.fill(minimum, amount + 1);
        minimum[0] = 0;
        for (int value = 1; value <= amount; value++) {
            for (int coin : coins) {
                if (coin <= value) minimum[value] = Math.min(minimum[value], minimum[value - coin] + 1);
            }
        }
        return minimum[amount] > amount ? -1 : minimum[amount];
    }
}
