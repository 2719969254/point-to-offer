//package com.kfzx.pinduoduo;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @author VicterTian
// * @version V1.0
// * @date 2019/4/15
// */
//public class Tets7 {
//    public static void main(String[] args) {
//        //硬币面值预先已经按降序排列
//        Scanner sc = new Scanner(System.in);
//        int count = sc.nextInt();
//
//        int[] coinValue = new int[count];
//        for (int i = 0; i < coinValue.length; i++) {
//            coinValue[i] = sc.nextInt();
//        }
//        Arrays.sort(coinValue);
//        //需要找零的面值
//        int money = sc.nextInt();
//        //保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
//
//        countWays(coinValue, money, coinsUsed);
//    }
//    public int countWays(int[] penny, int n, int aim) {
//        if (penny == null || penny.length == 0 || aim < 0) {
//            return 0;
//        }
//        int[][] dp = new int[n][aim + 1];
//        // 初始化第一行的值
//        for (int i = 0; i < aim + 1; i++) {
//            if (i % penny[0] == 0) {
//                dp[0][i] = 1;
//            }
//        }
//        // 初始化第一列的值
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < aim + 1; j++) {
//                for (int k = 0; j - k * penny[i] >= 0; k++) {
//                    dp[i][j] += dp[i - 1][j - k * penny[i]];
//                }
//            }
//        }
//        return dp[n - 1][aim];
//    }
//
//}
