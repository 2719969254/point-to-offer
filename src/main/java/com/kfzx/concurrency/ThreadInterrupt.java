package com.kfzx.concurrency;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/2/26
 */
@SuppressWarnings("all")
public class ThreadInterrupt {
	private static final Object MONITOR = new Object();

	public static void main(String[] args) throws InterruptedException {
		/*Thread t = new Thread() {
			@Override
			public void run() {
				while (true){
					synchronized (MONITOR){
						try {
							MONITOR.wait(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
							System.out.println(isInterrupted());
						}

					}
				}
			}
		};*/
		/*Thread t = new Thread(()->{
			while (true){
				synchronized (MONITOR){
					try {
						MONITOR.wait(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println(Thread.interrupted());
					}
				}
			}
		});*/
		Thread t = new Thread(){
			@Override
			public void run() {
				while (true){

				}
			}
		};
		t.start();
		Thread main = Thread.currentThread();
		Thread t2 = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				main.interrupt();
				System.out.println("interrupt");
			}
		};
		t2.start();
		t.join();

	}
}
