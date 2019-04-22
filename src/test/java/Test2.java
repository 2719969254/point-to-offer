import java.util.Scanner;

/**
 * 技能学习
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 人族和兽族为了争夺一处矿产掀起了世界大战。大战在即，先知召集兽族各勇士学习新的攻击技能。
 *
 * 先知想要让n(1<=n<=100000)个兽族勇士都分别学会k(1<=k<=100000)种技能，但一个一个教的效率太低，先知在精灵杂货铺那里买来了分身宝石，使用分身宝石后，就出现了m(1<=m<=100000)个先知。先知教会一个兽族勇士一个技能的时间是1分钟，一个兽族勇士在同一时间只能学习一个技能，一个先知在同一时间也只能教一个勇士学习技能，不同先知或不同勇士当然可以在同一时间教授或学习技能。
 *
 * 大战即将爆发，先知想要知道最少需要多久才能教会n个勇士分别学会k个技能？
 *
 * 输入
 * 一行三个整数n,k,m，以空格隔开
 *
 * 输出
 * 一行一个整数表示n个勇士分别学会k个技能的最少时间
 *
 *
 * 样例输入
 * 2 1 1
 * 样例输出
 * 2
 * @author VicterTian
 * @version V1.0
 * @date 2019/4/11
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int m = scan.nextInt();

		int mod = n%m;
		int sum = 0;
		if(mod!=0) {
			sum+=k;
		}
		sum+=(n/m)*k;
		System.out.println(sum);

	}
}
