package com.kfzx.concurrency;

/**
 * 叫号的逻辑实现
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/15
 */
public class TicketWindow extends Thread {
	private final String name;
	private final static int MAX = 50;
	private static int index = 1;

	TicketWindow(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (index <= MAX) {
			System.out.println("柜台：" + name + "当前的号码是:" + (index++));
		}
	}
}
