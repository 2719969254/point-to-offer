package com.kfzx.datastructure;

public class Test {
	public static void main(String[] args) {

		// 小数默认double类型的，如果要将一个小数定义成float需要在后面加 f
		float f = 100.3f;
		float f1 = 200.5f;
		float f2 = f + f1;
		System.out.println(f2);
		// 小数默认是double类型的，数字后面可以不加d
		double d = 200.0d;
		System.out.println(d);
		// 单个字符赋值给字符类型，用单引号括起来
		char c = '刘';
		System.out.println(c);
		// 转义字符的验证
		System.out.println("刘庆港和王鼎有一腿");
		// 布尔数据类型的验证
		boolean b = true;
		System.out.println(b);

		// 自动类型转换
		byte b2 = 20;
		int i2 = b2;
		System.out.println(i2);

		long a = 100;
		float f3 = a;
		System.out.println(f3);

		char c1 = 'A';
		int cc = c1;
		System.out.println(cc);
		//强制类型转换 需要在被转换的值前面加目标类型
		int a1 = 20;
		byte b1 = (byte) a1;
		System.out.println(b1);


	}
}