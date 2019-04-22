package com.kfzx.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/15
 */
public class CoinsChange {
    public static void makeChange(int[] values, int valueKinds, int money,
                                  int[] coinsUsed) {

        coinsUsed[0] = 0;
        for (int cents = 1; cents <= money; cents++) {

            int minCoins = cents;

            for (int kind = 0; kind < valueKinds; kind++) {
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        minCoins = temp;
                    }
                }
            }
            coinsUsed[cents] = minCoins;
            if (cents == money){
                System.out.println(coinsUsed[cents]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] coinValue = new int[count];
        for (int i = 0; i < coinValue.length; i++) {
            coinValue[i] = sc.nextInt();
        }
        Arrays.sort(coinValue);
        int money = sc.nextInt();
        int[] coinsUsed = new int[money + 1];
        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }
}