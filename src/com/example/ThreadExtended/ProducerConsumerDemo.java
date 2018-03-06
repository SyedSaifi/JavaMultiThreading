package com.example.ThreadExtended;

import java.util.Vector;

public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Vector vec = new Vector();
		int SIZE = 4;

		Thread thprod = new Thread(new ProducerDemo(vec, SIZE));
		Thread thcons = new Thread(new ConsumerDemo(vec, SIZE));

		thprod.start();
		thcons.start();
	}
}

class ProducerDemo implements Runnable {
	private final int SIZE;
	private final Vector vec;

	ProducerDemo(Vector vec, int SIZE) {
		this.vec = vec;
		this.SIZE = SIZE;
	}

	@Override
	public void run() {

		for (int i = 0; i < 7; i++) {
			System.out.println("Produces :: " + i);
			try {
				Producer(i);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void Producer(int i) throws InterruptedException {
		synchronized (vec) {
			if (vec.size() == SIZE) {
				System.out.println("Vector is full. Vector size is :: " + vec.size());
				vec.wait();
			}
		}
		synchronized (vec) {
			vec.notifyAll();
			vec.add(i);
		}

	}
}

class ConsumerDemo implements Runnable {
	private final int SIZE;
	private final Vector vec;

	ConsumerDemo(Vector vec, int SIZE) {
		this.vec = vec;
		this.SIZE = SIZE;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumers :: " + Consumer());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private int Consumer() throws InterruptedException {
		synchronized (vec) {
			if (vec.isEmpty()) {
				System.out.println("Vector is empty. The vector size is :: " + vec.size());
				vec.wait();
			}
		}
		synchronized (vec) {
			vec.notifyAll();
			return (int) vec.remove(0);

		}
	}
}
