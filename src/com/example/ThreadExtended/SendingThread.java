package com.example.ThreadExtended;

public class SendingThread extends Thread {
	CustomSemaphore semaphore = null;

	public SendingThread(CustomSemaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			this.semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " :: sent signal");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
