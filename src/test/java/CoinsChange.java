import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/15
 */
public class CoinsChange {
    /**
     * 硬币找零：动态规划算法
     *
     * @paramvalues :保存每一种硬币的币值的数组
     * @paramvalueKinds :币值不同的硬币种类数量，即coinValue[]数组的大小
     * @parammoney :需要找零的面值
     * @paramcoinsUsed :保存面值为i的纸币找零所需的最小硬币数
     */
    public static void makeChange(int[] values, int valueKinds, int money,
                                  int[] coinsUsed) {

        coinsUsed[0] = 0;
        int nowMoney = 0;
        //对每一分钱都找零，即保存子问题的解以备用，即填表 
        for (int cents = 1; cents <= money; cents++) {

            //当用最小币值的硬币找零时，所需硬币数量最多
            int minCoins = cents;

            //遍历每一种面值的硬币，看是否可作为找零的其中之一
            for (int kind = 0; kind < valueKinds; kind++) {
                if (values[kind] <= cents) {
                    int temp = coinsUsed[cents - values[kind]] + 1;
                    if (temp < minCoins) {
                        /*System.out.println(temp);*/
                        minCoins = temp;
                    }
                }
            }
            //保存最小硬币数
            coinsUsed[cents] = minCoins;
            if (cents == money) {
                System.out.println(coinsUsed[cents]);
                /*System.out.println(nowMoney);*/
                return;
            }
            nowMoney = 0;

        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        //硬币面值预先已经按降序排列
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] coinValue = new int[count];
        for (int i = 0; i < coinValue.length; i++) {
            coinValue[i] = sc.nextInt();
        }
        Collections.reverse(Arrays.asList(coinValue));
        //需要找零的面值 
        int money = sc.nextInt();
        //保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1 
        int[] coinsUsed = new int[money + 1];
        makeChange(coinValue, coinValue.length, money, coinsUsed);
    }
}