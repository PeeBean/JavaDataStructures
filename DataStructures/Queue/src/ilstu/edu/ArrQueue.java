package ilstu.edu;

import java.util.Queue;

public class ArrQueue<E>
{
	private int capacity;
	private int front;
	private int rear;
	private int size;
	private E[] theData;
	public ArrQueue(int initCapacity)
	{
		capacity = initCapacity;
		theData = (E[])new Object[capacity];
		front = 0;
		rear = capacity-1;
		size =0;
	}
	
	public boolean offer(E item)
	{
		if(size == capacity)
			reallocate();
		size++;
		rear = (rear+1) % 5;
		theData[rear] = item;
		return true;
		
	}
	public E poll()
	{
		if(size == 0)
			return null;
		E result = theData[front];
		front = (front +1) % 5;
		size--;
		return result;
	}
	public void reallocate()
	{
		int newCapacity = 2*capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int j =front;
		for(int i =0; i <size; i++)
		{
			newData[i] = theData[j];
			j = (j+1) % capacity;
		}
		front = 0;
		rear = size-1;
		capacity = newCapacity;
		theData = newData;
	}
	
	public static void move(Queue<String>line)
	{
		String item = line.poll();
		line.offer(item);
		int count = 1;
		
		while(line.peek()!=item)
		{
			line.offer(line.poll());
			count++;
		}
		for(int i =0; i < count; i++)
		{
			line.offer(line.poll());
		}
	}
	
}
