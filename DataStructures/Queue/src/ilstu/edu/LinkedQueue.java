package ilstu.edu;


public class LinkedQueue<E>
{
	private Node<E> front;
	private Node<E> tail;
	
	public boolean offer(E item)
	{
		if(front == null)
		{
			front = new Node<E>(item);
			tail = front;
			return true;
		}
		tail = new Node<E>(item, tail);
		return true;
			
	}
	
	public E poll()
	{
		if(front == null)
			return null;
		E result = front.data;
		front = front.next;
		return result;
	}
	
	
	public E peek()
	{
		if(front == null) {}
			//Throw exception
		E result = front.data;
		return result;
	}
	
	
	private static class Node<E> 
	{
		private E data;
		private Node<E> next;
		
		public Node(E data)
		{
			this.data = data;
		}
		public Node(E data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	
}
