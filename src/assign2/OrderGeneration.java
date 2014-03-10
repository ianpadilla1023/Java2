package assign2;

import java.util.Scanner;

public class OrderGeneration implements Runnable {

	/**
	 * @param args
	 */
	Thread thread;
	public OrderGeneration(){
		thread = new Thread(this, "Generation Thread");
		thread.start();
	}
	
	private String ThreadName = "Order Generation ";
	public void run( ){
	     try {
	    	 Scanner sc = new Scanner(System.in);
	 		System.out.print("");
	 		
	         for(int i = 5; i > 0; i--) {
	            System.out.println(ThreadName + i);
	            // Let the thread sleep for one second.
	            Thread.sleep(1000);
	         }
	     } catch (InterruptedException e) {
	         System.out.println(ThreadName + "Thread interrupted.");
	     }
	     System.out.println("Exiting " + ThreadName + "thread.");
	   }
	
	public Thread.State getState(){
		return thread.getState();
	}
}
