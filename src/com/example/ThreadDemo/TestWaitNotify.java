package com.example.ThreadDemo;

class Customer{  
	int amount=10000;  

	void withdraw(int amount){ 
		synchronized(this){
			System.out.println("going to withdraw...");  

			if(this.amount<amount){  
				System.out.println("Less balance; waiting for deposit...");  
				try{
					wait();
				}catch(Exception e){}  
			}

			this.amount-=amount;  
			System.out.println("withdraw completed...");  
		}  
	}

	synchronized void deposit(int amount){  
		System.out.println("going to deposit...");  
		this.amount+=amount;  
		System.out.println("deposit completed... ");  
		notify();  
	}  
}  

public class TestWaitNotify{  
	public static void main(String args[]){  
		final Customer c=new Customer();  
		new Thread(){  
			public void run(){c.withdraw(15000);}  
		}.start();  
		new Thread(){  
			public void run(){c.deposit(10000);}  
		}.start();  

	}}  