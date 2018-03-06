package com.example.ThreadDemo;

public class ShutdownHook {

public static void main(String[] args) {
	Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            System.out.println("exit");
        }
    });
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}