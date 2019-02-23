package com.kfzx.codinginterview;

/**
 * 青蛙跳台阶扩展
 * <p>
 * 在青蛙跳台阶时问题中，如果把条件改成：一只青蛙可以跳1级台阶，也可以跳2、3、、、n级台阶，有多少种跳法
 * 现在我们用数学归纳法来分析一下这个变种问题：
 * <p>
 * 首先，当n=1时，只有一种跳法  f(1)=1。
 * <p>
 * 其次，当n=2时，有两种跳法，每次跳1阶，或者一次性跳2阶。f(2) =2。
 * <p>
 * 当n=3时，有4种跳法，第一种方式是第一次跳1阶，剩下的2个台阶有f(2)次跳法，f(2)=2，第二种方式是第一次跳2阶，剩下的1个台阶有f(1)=1种跳法，第三种方式是一次性跳3阶，f(0)=1。所以当n=3时，有f(2)+f(1)+f(0)=4。
 * <p>
 * 当分析到n=3时，我们发现这种场景下，可以归纳到n>3时，f(n)=f(n-1)+f(n-2)+f(n-3)+f(...)+f(0)。而f(n-1)=f(n-2)+f(n-3)+f(n-4)+f(n-5)+f(..)+f(0)。两式相减，得到f(n)-f(n-1)=f(n-1)，整理可以得到f(n)=f(n-1)*2
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/1/23
 */
public class P78_JumpFloorExtend {
	public int jumpFloorII(int n){
		if(n==1 || n==2){
			return n;
		}else{
			return jumpFloorII(n-1)*2;
		}
	}
	public static void main(String[] args) {
		P78_JumpFloorExtend jumpFloor = new P78_JumpFloorExtend();
		System.out.println("jumpFloor.jumpFloorII(5) = " + jumpFloor.jumpFloorII(5));

	}
}
