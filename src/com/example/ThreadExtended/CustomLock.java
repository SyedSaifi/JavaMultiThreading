package com.example.ThreadExtended;

public class CustomLock {
	
	private boolean isLocked = false;

	  public synchronized void lock() throws InterruptedException{
	    while(isLocked){
	      wait();
	    }
	    isLocked = true;
	  }

	  public synchronized void unlock(){
	    isLocked = false;
	    notify();
	  }
	  
	 class Counter{

		  private CustomLock lock = new CustomLock();
		  private int count = 0;

		  public int inc() throws InterruptedException{
		    lock.lock();
		    int newCount = ++count;
		    lock.unlock();
		    return newCount;
		  }
		}

}
