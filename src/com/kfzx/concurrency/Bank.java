package com.kfzx.concurrency;

/**
 * 采用多线程方式实现银行叫号
 *
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/15
 */
public class Bank {
	public static void main(String[] args) {
		TicketWindow ticketWindow1 = new TicketWindow("一号柜台");
		TicketWindow ticketWindow2 = new TicketWindow("二号柜台");
		TicketWindow ticketWindow3 = new TicketWindow("三号柜台");
		ticketWindow1.start();
		ticketWindow2.start();
		ticketWindow3.start();
	}
}
