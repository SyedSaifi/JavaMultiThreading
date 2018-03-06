package com.example.ThreadExtended;

import java.util.LinkedList;
import java.util.List;

public class CustomBlockingQueue {

	private List queue = new LinkedList();
	private int limit;

	public CustomBlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
		System.out.println("Added :: " + item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		System.out.println("Item removed::" + queue.get(0));
		return this.queue.remove(0);
	}

	public static void main(String args[]) throws InterruptedException {
		CustomBlockingQueue bq = new CustomBlockingQueue(2);

		new Thread() {
			public void run() {
				try {
					bq.enqueue(22);
					bq.enqueue(33);
					//bq.enqueue(44);
					bq.dequeue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

	}
}