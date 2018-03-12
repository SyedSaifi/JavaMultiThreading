package com.example.ThreadDemo;

import java.util.ArrayList;
import java.util.List;
 
public class MyThreadJoin {
 
    public static List<String> names = new ArrayList<String>(); 
     
    public static void main(String a[]){
        List<SampleThread> list = new ArrayList<SampleThread>();
        for(int i=0;i<5;i++){
            SampleThread s = new SampleThread();
            list.add(s);
            s.start();
        }
        for(SampleThread st:list){
            try{
                st.join();
            } catch (Exception ex){}
        }
        System.out.println(names);
    }
}
 
class SampleThread extends Thread{
     
    public void run(){
        for(int i=0; i<1; i++){
            try{
                Thread.sleep(100);
            } catch(Exception ex){}
        }
        MyThreadJoin.names.add(getName());
    }
}