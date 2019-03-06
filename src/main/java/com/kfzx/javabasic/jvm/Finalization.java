package com.kfzx.javabasic.jvm;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/4
 */
public class Finalization {
	public static Finalization finalization;

	@Override
	protected void finalize() {
		System.out.println("Finalized");
		finalization = this;
	}

	public static void main(String[] args) throws InterruptedException {
		Finalization f = new Finalization();
		System.out.println("Finalization First"+f);
		f = null;
		System.gc();
		Thread.sleep(1000);
		System.out.println(f);
		System.out.println(finalization);
	}
}
