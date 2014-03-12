package assign2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class OrderGeneration implements Runnable {

	/**
	 * @param args
	 */
	Thread thread;
	public OrderGeneration(Main parent){
		parentthread =  parent;
		thread = new Thread(this, "Generation Thread");
		thread.start();
	}
	
	private final Main parentthread;
	
	private Queue<Product> OrderQueue = new LinkedList<Product>();	
	private String ThreadName = "Order Generation ";
	public void run( ){
	     try {
	    	 OrderQueue = parentthread.GetOrderQueue();
	    	
	    	 Scanner sc = new Scanner(System.in);
	 		System.out.print("Number of products to generate: ");
	 		int input = sc.nextInt();
	 		String[] names = {
	 				"dish", "washer", "vacuum", "cleaner", "electric", "tabletop", "oven", "washing", "machine", "appliance",
	 				 "microwave", "oven", "alarmclock", "blender", "toaster", "rice", "cooker", "deepfryer", "spray", "bowl", "fork",
	 				 "mr.clean", "garbage", "bag"};
	        ArrayList<String> Names = new ArrayList();
	        for(int i = 0; i < names.length; i++){
	        	Names.add(names[i]);
	        }
	        Random r = new Random();
	        float minX = 10.00f;
	        float maxX = 10000.00f;
	        
	 		for(int i = input; i > 0; i--) {
	        	Product newp = new Product(Names.get(r.nextInt(Names.size()))+" "+ Names.get(r.nextInt(Names.size())), Float.parseFloat(Double.toString(((Math.round((r.nextFloat() * (maxX - minX) + minX))*100.00) / 100.00))));
	        	OrderQueue.add(newp);
	            System.out.println(ThreadName + ":: " + newp.toString());
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
