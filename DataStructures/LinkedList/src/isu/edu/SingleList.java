package isu.edu;

public class SingleList<E> 
{
	private Node<E> head;
	private int size;
	
	private Node<E> getNode(int index)
	{
		Node<E> cur = head;
		for(int i = 0; i < index && cur!=null; i++)
		{				
			cur = cur.next;
		}
		return cur;
	}
	public E get(int index)
	{
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index);
		Node<E> target = getNode(index);
		return target.data;
	}
	public E set(int index, E item)
	{
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index);
		Node<E> target = getNode(index);
		E result = target.data;
		target.data = item;
		return result; 
	}
	
	
	
	public void addFirst(E item)
	{
		head = new Node<E>(item, head);//Right side of argument is completed first.. so original head becomes new nodes next
		size++;
	}
	private void addAfter(Node<E> node, E item) //Private because it is a helper method- not in API
	{
		node.next = new Node<E>(item, node.next);
		size++;
	}
	
	
	public E removefirst()
	{
		if(head != null)
		{
			E temp = head.data;
			head = head.next; //Java removes things from memory when there is no reference pointing to the object
			size--;
			return temp;
		}
		return null;
	}
	private E removeAfter(Node<E> node)
	{
		Node<E> temp = node.next;
		if(temp != null)
		{
			node.next = temp.next;
			size--;
			return temp.data;
		}
		return null;
		
	}
	
	public void print()
	{
		Node<E> current = head;
		while(current!=null)
		{
			System.out.println(current.data);
			current = current.next;
		}
	}
	public int size()
	{
		return this.size;
	}
	
	public void add(E item)
	{
		if(head == null)
			addFirst(item);
		else
			{
			Node<E> current = head;
			while(current.next!=null)
				current = current.next;
			addAfter(current, item);
			}
	}
	public void add(int index, E item)
	{
		if(index<0||index>size)
			throw new IndexOutOfBoundsException(index);
		if(index ==0)
			addFirst(item);
		else
		{
			Node<E> node = getNode(index-1);
			addAfter(node,item);
		}
	}
	
	public void addCenter(E item) //Assumes list size is even
	{
		Node<E> temp = head;
		if(temp != null)
		{
			for(int i = 0; i < this.size/2+1;i++)
			{
				temp = temp.next;
			}
			Node<E> n = new Node(item,temp.next);
			temp.next = n;
		}
		else
		{
			head = new Node(item);
		}
		size++;
	}
	
	public void printEvens()
	{
		Node<E> temp = head;
		int count =0;
		while(temp!=null)
		{
			if(count%2==0)
				System.out.println(temp.data);
			count++;
			temp = temp.next;
		}
	}
	public void addAfterEvens(E item)
	{
		Node<E> temp = head;
		for(int i =0; i < size; i+=2)
		{
			Node<E>curr = new Node<E>(item,temp.next);
			temp.next = curr;
			size++;
			temp = temp.next;
		}
		
		if(temp == null)
		{
			head = new Node<E>(item);
			size++;
		}
	}
		
	public SingleList<E> getReverse()
	{
		SingleList<E> newList = new SingleList<E>();
		if(head == null)
			return null;
		Node<E> temp = head;
		while(temp!=null)
		{
			newList.addFirst(temp.data);
			temp = temp.next;
		}
		return newList;
	}
	
	//Try removing even indices
	
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
