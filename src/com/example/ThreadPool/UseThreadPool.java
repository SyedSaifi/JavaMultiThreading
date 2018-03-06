package com.example.ThreadPool;

public class UseThreadPool {

	public static void main(String[] args) {
		Task1 t1 = new Task1();
		Task2 t2 = new Task2();
		Task3 t3 = new Task3();
		
		ThreadPool tp = new ThreadPool(2, 2);
		
		try {
			tp.execute(t1);
			tp.execute(t2);
			//tp.stop();
			tp.execute(t3);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
