package com.kfzx.design.proxy.jdk;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/9
 */
public class TestFindLove {
	public static void main(String[] args) {
		Person obj = (Person) new Meipo().getInstance(new Xiaoxingxing());
		System.out.println(obj.getClass());
		obj.findLove();
	}
}
