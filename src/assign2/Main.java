package assign2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	private Queue<Product> OrderQueue = new LinkedList<Product>();	
	private Queue<Product> ProductionQueue = new LinkedList<Product>();	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome to the company production line. \n 1. Generate Products" +
				"\n 2. View Products \n 3. Package and Ship Products \n Enter your selection: ");
		String input = sc.next();
		if(Integer.parseInt(input) == 1){
			OrderGeneration og = new OrderGeneration(); //Start a new thread in the construtor of this object
			
			while(true){
			Thread.State status = og.getState();
				if(status != Thread.State.RUNNABLE){//Loop until the status of the thread is not running
					if(status != Thread.State.TIMED_WAITING){ // or sleeping
					System.out.print(og.getState());
					break;
					}
				}
			}		
		}	
	}
}
