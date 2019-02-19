package com.kfzx.exercises;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	/*public static void main(String[] args) {
		ConcurrentHashMap<ConcurrentHashMap<String, Integer>, Integer> myHashMap = new ConcurrentHashMap<>();
		ConcurrentHashMap<String, Integer> temp = new ConcurrentHashMap<>();
		temp.put("1", 1);
		temp.put("2", 2);
		myHashMap.put(temp, 3);
		for (Iterator<Map.Entry<ConcurrentHashMap<String, Integer>, Integer>>
		     it = myHashMap.entrySet().iterator(); it.hasNext();){
			Map.Entry<ConcurrentHashMap<String, Integer>, Integer> item = it.next();
			ConcurrentHashMap<String, Integer> to_put = new ConcurrentHashMap<>(item.getKey());
			to_put.remove("1");
			myHashMap.put(to_put, item.getValue());
			System.out.println(myHashMap.size());
			it.remove();
			System.out.println(myHashMap.size());
		}
	}*/
	public static void main(String[] args) {
		final Map<String, String> map = new HashMap<>(2);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100000; i++){
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");

						}
					}).start();
				}
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
