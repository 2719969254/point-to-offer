import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 玩游戏
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 这天，阳阳和他的小伙伴们一起玩游戏！
 * 他们总共有n个人，排成一圈，然后从第一个人开始依次报数，1，2，3，....,报到m的人退出游戏，
 * 然后从下一个人开始重新从1报数，重复这个过程，直到只剩下一个人时，此人就是游戏的获胜者
 *
 * 输入
 * 两个整数n和m
 *
 * 1<=n,m<=1000
 *
 * 输出
 * 第一行n-1个数，依次表示退出游戏的人。
 *
 * 第二行一个数表示获胜者编号。
 *
 * 样例输入
 * 6 4
 * 样例输出
 * 4 2 1 3 6
 * 5
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (m <= 0) {
			return;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int j = 0, k = 1;
		while (list.size() > 1) {
			if (j == list.size()) {
				j = 0;
			}
			if (k == m) {
				if (list.size()>=2){
					System.out.print(list.get(j) + " ");
				}else{
					System.out.print(list.get(j));
				}

				list.remove(j);
				k = 1;
			} else {
				j++;
				k++;
			}
		}
		System.out.println();
		System.out.println(list.get(0));
	}
}
