package com.syg.manage.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 通过future cancel 取消线程
 * @author sg
 *
 */
public class ThreadFuture {

	public static void main(String[] args) {  
        ExecutorService eService = Executors.newFixedThreadPool(5);
        RunFuture c=new RunFuture();
        Future<?> future= eService.submit(c);
        try {  
            Thread.sleep(3000);
            future.cancel(true);
            c.setCancel(true);
            //Thread.interrupted();//无效
            System.out.println("---结束---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }  
  
}  
	class RunFuture implements Runnable{
	    int i=0;
	    private boolean cancel;
	    @Override
	    public void run() {
//	    	while (i<100000) {
//	            System.out.println("i++:"+i);
//	            i++;  
//	        }
//	        while (i<100000) {
//	        	System.out.println(i+":"+Thread.currentThread().isInterrupted());
//	        	if (!Thread.currentThread().isInterrupted()) {
//		            System.out.println("i++:"+i);
//		            i++;  
//				}
//	        }
//    		while (true) {
//    			 System.out.println(Thread.currentThread().isInterrupted());
// 	        	 if(Thread.currentThread().isInterrupted()){
// 	                 System.out.println("Someone interrupted me.");  
// 	             }  
// 	             else{
// 	                 System.out.println("Going...");  
// 	             }  
// 	        }
//    		while (true && !Thread.currentThread().isInterrupted()) {
// 	             System.out.println("Going...");
// 	        }
    		 
//	    	while (true) {
//	    		if(!cancel){
//		    		System.out.println("Going...");
//		    	}else {
//					System.out.println("Cancel");
//					return;
//				}
//			}
	    	try {
	    		while (true) {
		    		if(cancel)return;
			    	System.out.println("going...");
				}
			} catch (Exception e) {
				
			}finally{
				System.out.println("cancel");
			}
	    	
	    }
	    
		public boolean isCancel() {
			return cancel;
		}
		public void setCancel(boolean cancel) {
			this.cancel = cancel;
		}  
	}
