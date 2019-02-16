package com.kfzx.concurrency;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/15
 */
public class BankWithRunnable {
	public static void main(String[] args) {
		TicketWindowWithRunnable runnable = new TicketWindowWithRunnable();
		Thread thread1 = new Thread(runnable,"一号窗口");
		Thread thread2 = new Thread(runnable,"二号窗口");
		Thread thread3 = new Thread(runnable,"三号窗口");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
