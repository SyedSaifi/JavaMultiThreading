package com.example.ThreadPool;

public class Task3 implements Runnable{
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" :: Performing task3");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
