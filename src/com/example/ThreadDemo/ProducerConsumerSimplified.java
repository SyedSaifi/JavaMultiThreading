package com.example.ThreadDemo;

import java.util.Vector;

public class ProducerConsumerSimplified {
	public static void main(String[] args){
		Vector vec = new Vector();
		int SIZE=4;
		
		Thread thprod = new Thread(new ProducerSimplified(vec,SIZE));
		Thread thcons = new Thread(new ConsumerSimplified(vec, SIZE));
		
		thprod.start();
		thcons.start();
		
	}

}

class ProducerSimplified implements Runnable{
	private final int SIZE;
	private final Vector vec;
	
	ProducerSimplified(Vector vec, int SIZE){
		this.vec=vec;
		this.SIZE=SIZE;
	}

	@Override
	public void run() {
		
	for(int i=0;i<7;i++){
		System.out.println("Produces :: "+ i);
		try{
			ProducerSimplified(i);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
	}
	}
	
	private void ProducerSimplified(int i) throws InterruptedException{
		synchronized (vec) {
			if(vec.size()==SIZE){
				System.out.println("Vector is full. Vector size is :: "+vec.size());
				vec.wait();
			}
		}
		synchronized (vec) {
			vec.notifyAll();
			vec.add(i);
		}
		
	}
}

class ConsumerSimplified implements Runnable{
	private final int SIZE;
	private final Vector vec;
	
	ConsumerSimplified(Vector vec, int SIZE){
		this.vec=vec;
		this.SIZE=SIZE;
	}

	@Override
	public void run() {
		while(true){
			try{
			System.out.println("Consumers :: "+ConsumerSimplified());
			Thread.sleep(50);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	private int ConsumerSimplified() throws InterruptedException{
		synchronized (vec) {
			if(vec.isEmpty()){
				System.out.println("Vector is empty. The vector size is :: "+vec.size());
				vec.wait();
			}
		}
		synchronized (vec) {
			vec.notifyAll();
			return (int)vec.remove(0);
			
		}
	}
}
