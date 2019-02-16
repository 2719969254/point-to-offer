package com.kfzx.javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/10
 */
public class ReflectSample {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
		Class<?> rc = Class.forName("com.kfzx.javabasic.reflect.Robot");
		Robot o = (Robot) rc.newInstance();
		System.out.println(rc.getName());
		Method throwHello = rc.getDeclaredMethod("throwHello", String.class);
		throwHello.setAccessible(true);
		Object obj = throwHello.invoke(o, "job");
		System.out.println("obj = " + obj);
		Method sayHi = rc.getDeclaredMethod("sayHi", String.class);
		sayHi.invoke(o, "hhh");
		Field name = rc.getDeclaredField("name");
		name.setAccessible(true);
		name.set(o,"tianzuo");
		sayHi.invoke(o, "hhh");
	}
}
