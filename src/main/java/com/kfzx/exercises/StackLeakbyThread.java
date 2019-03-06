package com.kfzx.exercises;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/3/1
 */
public class StackLeakbyThread {
	public static void main(String[] args) {
		StackLeakbyThread stackLeakbyThread = new StackLeakbyThread();
		stackLeakbyThread.stackLeakbyThread();
	}
	public void stackLeakbyThread(){
		while (true){
			new Thread(){
				@Override public void run() {
					while (true){

					}
				}
			}.start();
		}
	}
}
