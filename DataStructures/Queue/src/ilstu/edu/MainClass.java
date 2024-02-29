package ilstu.edu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MainClass {

	public static void main(String[] args) 
	{
		Queue<String> names = new LinkedList<String>();
		names.offer("sam");
		names.offer("mike");
		names.offer("Tim");
		
		
		Deque<String> line = new ArrayDeque<>();
		line.offerFirst("sam");
		line.offerLast("mike");
		line.offerFirst("Tim");
		System.out.println(line);
		
		
		//Dequeue are used often to create double ended stack
		//
		
		
	}
	
}
