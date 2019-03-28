package com.kfzx.design.proxy.jdk;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/9
 */
public class Xiaoxingxing implements Person{
	private String sex = "女";
	private String name = "小星星";

	@Override
	public void findLove() {
		System.out.println("我叫" + this.name + ",性别:" + this.sex + "我找对象的要求是:");
		System.out.println("高富帅");
		System.out.println("有房有车的");
		System.out.println("身高要求180cm以上，体重70kg");
	}

	@Override
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
