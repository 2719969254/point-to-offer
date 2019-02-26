package com.kfzx.concurrency;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/26
 */
@SuppressWarnings("all")
public class ThreadJoin2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			System.out.println("t1 is running");
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t1 is done");
		});
		t1.start();
		t1.join(10, 10);
		Optional.of("All of tasks finish done.").ifPresent(System.out::println);
		IntStream.range(1, 1000000)
				.forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
	}

}
