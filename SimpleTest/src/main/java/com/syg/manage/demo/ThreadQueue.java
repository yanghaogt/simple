package com.syg.manage.demo;

/**
 * 线程  start / new Thread().start();
 * @author sg
 *
 */
public class ThreadQueue {

	static class Bank{  
	    private int sum;  
	    public void add(int n){  
	         sum+=n;  
	         System.out.println("sum="+sum);  
	    }  
	}  
	
	static  class Cus implements Runnable{  
	   private Bank b=new Bank();
	   public void run(){
	         for(int x=0;x<20;x++){
	            b.add(100);
	         }  
	     }  
	}  
	
	public static void main(String[] args) {
		Cus c=new Cus();
        Thread t1=new Thread(c);  
        Thread t2=new Thread(c);
        t1.start();
        t2.start();
        
        new Thread(
        	new Runnable(){
				@Override
				public void run() {
					System.out.println("nihao:"+1);
				}
			}
        ).start();
	}
}
