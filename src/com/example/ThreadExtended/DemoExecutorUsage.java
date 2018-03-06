package com.example.ThreadExtended;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoExecutorUsage {
	 
    public static void main(String[] args) {
    	ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.submit(new TestOne());
            executor.submit(new TestTwo());
                
            executor.shutdown();
    }
}
 
class TestOne implements Runnable {
    public void run() {
            System.out.println(Thread.currentThread().getName()+":: Executing task one");
    }
}
 
class TestTwo implements Runnable {
    public void run() {
            System.out.println(Thread.currentThread().getName()+":: Executing task two");
        }
}

