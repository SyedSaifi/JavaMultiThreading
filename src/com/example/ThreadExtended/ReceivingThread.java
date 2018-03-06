package com.example.ThreadExtended;

public class ReceivingThread extends Thread {
	CustomSemaphore semaphore = null;

	public ReceivingThread(CustomSemaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			this.semaphore.release();
			System.out.println(Thread.currentThread().getName() + " :: recived signal");
			// receive signal, then do something...
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
