package com.kfzx.javabasic.reflect;

public class TestSynchronized {
	public synchronized void test1() {
		int i = 5;
		while (i-- > 0) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}

	public static synchronized void test2() {
		int i = 5;
		while (i-- > 0) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}

	public static void main(String[] args) {
		final TestSynchronized myt2 = new TestSynchronized();
		new Thread(() -> myt2.test1()).start();
		new Thread(()->test2()).start();

	}

}

