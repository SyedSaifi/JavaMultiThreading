package com.example.ThreadPool;

public class Task1 implements Runnable{
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" :: Performing task1");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
