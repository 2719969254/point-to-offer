package com.kfzx.concurrency;

import java.util.stream.IntStream;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/26
 */
@SuppressWarnings("all")
public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			IntStream.range(1, 1000).forEach(i -> System.out.println((Thread.currentThread().getName() + "->" + i)));
		});
		Thread t2 = new Thread(() -> {
			IntStream.range(1, 1000).forEach(i -> System.out.println((Thread.currentThread().getName() + "->" + i)));
		});
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		IntStream.range(1, 1000).forEach(i -> System.out.println((Thread.currentThread().getName() + "->" + i)));
	}
}
