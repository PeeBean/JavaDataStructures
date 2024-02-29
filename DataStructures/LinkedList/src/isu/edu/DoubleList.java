package isu.edu;

public class DoubleList<E>
{
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		private Node(E data)
		{
			this.data = data;
		}
		private Node(E data, Node<E> node)
		{
			this.data = data;
			this.next = node;
		}
	}
	
	public void printReversed()
	{
		Node<E> temp = tail;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}
	/*
	public boolean checkSorted() //Only works for ints and such
	{
		Node<E> left = head;
		Node<E> right = tail;
		if(head != null)
		{
			while(head.next!=null || tail.prev != null)
			{
				if(left.next.data < left.data)
				{
					return false;
				}
				if(right.prev.data > right.data) {
					return false;
				}
				left = left.next;
				right = right.prev;
			}
			return true;
		}
		return true;
	}
	
	*/
	
	private void addAfter(Node<E> node, E item)
	{
		Node<E> temp = new Node<E>(item,node.next);
		node.next.prev = temp;
		node.next = temp;
		size++;
	}
	private void addFirst(E item)
	{
		head = new Node<E>(item);
		tail = head;
		size++;
	}
	public void add(E item)
	{
		if(head == null)
			addFirst(item);
		else
		{
			Node<E> temp = head;
			while(temp.next!=null)
				temp=temp.next;
			addAfter(temp,item);	
		}
	}
	
}
