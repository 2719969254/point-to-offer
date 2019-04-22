package com.kfzx.pinduoduo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] coinValue = new int[count];
        for (int i = 0; i < coinValue.length; i++) {
            coinValue[i] = sc.nextInt();
        }
        Collections.reverse(Arrays.asList(coinValue));

        int money = sc.nextInt();
        System.out.println(coinChange(coinValue, money));
    }
    public static int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i=0;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }

            }
        }
        //这里如果没有赋值的话那么就是找零不了的情况
        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];

    }
}