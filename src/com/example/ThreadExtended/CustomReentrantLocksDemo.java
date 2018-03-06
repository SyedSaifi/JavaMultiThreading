package com.example.ThreadExtended;

public class CustomReentrantLocksDemo
{
	CustomReentrantLock lock = new CustomReentrantLock();

	public void outer() throws InterruptedException
	{
		lock.lock();
		inner();
		lock.unlock();
	}

	private synchronized void inner() throws InterruptedException
	{
		lock.lock();
		// do something
		lock.unlock();
	}
}
