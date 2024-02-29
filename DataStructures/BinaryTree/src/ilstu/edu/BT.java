package ilstu.edu;

import java.io.Serializable;
import java.util.Scanner;


public class BT<E> implements Serializable
{
	protected Node<E> root;
	
	public BT()
	{
		
	}
	protected BT(Node<E> root)
	{
		this.root = root;
	}
	public BT(E data, BT<E> leftTree, BT<E> rightTree)
	{
		this.root = new Node<E>(data);
		if(leftTree != null)
			this.root.left = leftTree.root;
		if(rightTree != null)
			this.root.right = rightTree.root;

	}
	
	public E getData()
	{
		return this.root.data;
	}
	public boolean isLeaf() 
	{
		return root.left == null && root.right == null;
	}
	public BT<E> getLeftSubTree()
	{
		return new BT<E>(root.left);
	}
	public BT<E> getRightSubTree()
	{
		return new BT<E>(root.right);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
	{
		for(int i =1; i < depth; i++)
		{
			sb.append("  "); //Indentation
		}
		if(node == null)
		{
			sb.append("null\n");
		}
		else
		{
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	
	public static BT<String> readBT(Scanner scan)
	{
		String data = scan.next();
		if(data.equals("null"))
		{
			return null;
		}
		BT<String> leftTree = readBT(scan);
		BT<String> rightTree = readBT(scan);
		return null;
		
	}
	
	
	protected static class Node<E> implements Serializable
	{
		protected E data;
		Node<E> left;
		Node<E> right;
		
		public Node(E data)
		{
			this.data = data;
		}
		
		public String toString()
		{
			return this.data.toString();
		}
	}
	
}
