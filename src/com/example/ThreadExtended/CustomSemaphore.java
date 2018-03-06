package com.example.ThreadExtended;

/*1. To guard a critical section against entry by more than N threads at a time.
  2. To send signals between two threads.*/

public class CustomSemaphore {
	private int signals = 0;
	private int bound = 0;

	public CustomSemaphore(int upperBound) {
		this.bound = upperBound;
	}

	public synchronized void acquire() throws InterruptedException {
		while (this.signals == bound)
			wait();
		this.signals++;
		this.notify();
	}

	public synchronized void release() throws InterruptedException {
		while (this.signals == 0)
			wait();
		this.signals--;
		this.notify();
	}

	public static void main(String[] args) {

		CustomSemaphore semaphore = new CustomSemaphore(3);

		SendingThread sender = new SendingThread(semaphore);
		SendingThread sender1 = new SendingThread(semaphore);
		SendingThread sender2 = new SendingThread(semaphore);

		ReceivingThread receiver = new ReceivingThread(semaphore);

		sender.start();
		sender1.start();
		sender2.start();
		receiver.start();

	}
}
