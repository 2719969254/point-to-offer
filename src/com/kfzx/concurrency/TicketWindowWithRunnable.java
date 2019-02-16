package com.kfzx.concurrency;

/**
 * 采用runnable方式实现叫号逻辑
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/15
 */
public class TicketWindowWithRunnable implements Runnable {

	private int index = 1;
	private final static int MAX = 50;

	@Override
	public void run() {
		synchronized (this){
			while (index<=MAX){
				System.out.println(Thread.currentThread()+"的号码是："+(index++));
			}
		}
	}
}
