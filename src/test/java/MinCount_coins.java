import java.util.Scanner;

public class MinCount_coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int coins[] = new int[count];
        int k = scanner.nextInt();
        int road[] = new int[k + 1];
        int min = getMinCount(k, coins, road);
        if (min > Integer.MAX_VALUE - k) { //min 没有另外赋值，则表示零钱不够
            System.out.println(-1);
        } else {
            System.out.println("数值为" + k + " 时，需要的最少的硬币数为： " + min);
            for (int j = k; j > 0; ) {
                System.out.print(road[j] + "\t");
                j = j - road[j];  //j为当前要找的零钱值， road[j]为当前面额下，最近加入的零钱
            }
        }
    }

    public static int getMinCount(int k, int c[], int r[]) {
        int a[] = new int[k + 1];//保存最近加入的零钱值
        a[0] = 0;
        for (int x = 1; x < k + 1; x++) { //要求a[k],先求a[1]~a[k-1]
            if (x >= c[0]) {  //给a[x]附初值
                a[x] = a[x - c[0]] + 1;
                r[x] = c[0];
            } else {   //要找零钱比最小零钱值还小，零钱不够
                a[x] = Integer.MAX_VALUE - k;
            }
            for (int i = 1; i < c.length; i++) {
                if (x >= c[i] && (a[x] > a[x - c[i]] + 1)) {
                    a[x] = a[x - c[i]] + 1;
                    r[x] = c[i];
                }
            }
        }
        return a[k];
    }


}