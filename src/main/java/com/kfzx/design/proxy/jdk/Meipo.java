package com.kfzx.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/9
 */
public class Meipo implements InvocationHandler {
	/**
	 * 被代理对象的引用作为一个成员变量被保存了下来
	 */
	private Person target;

	public Object getInstance(Person target){
		this.target = target;
		Class<? extends Person> clazz = target.getClass();
		System.out.println("被代理对象是："+clazz);
		return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("我是媒婆：" + "得给你找个异性才行");
		System.out.println("开始进行海选...");
		System.out.println("------------");

		method.invoke(this.target,args);
		System.out.println("------------");
		System.out.println("如果合适的话，就准备办事");
		return null;
	}
}
