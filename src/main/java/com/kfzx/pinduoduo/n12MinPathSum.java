package com.kfzx.pinduoduo;

import java.util.Scanner;

public class n12MinPathSum {

    public static int[][] a;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = input.nextInt();
            }
        }
        System.out.println(minPathSum(a));
    }

    public static int minPathSum(int[][] a) {
        int N = a.length;
        int M = a[0].length;
        int[][] dp = new int[N][M];
        dp[0][0] = a[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = a[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = a[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
            }
        }


        return dp[N - 1][M - 1];
    }

}