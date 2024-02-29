package ilstu.edu;

public class BST<E extends Comparable> extends BT<E>
{
	protected boolean addReturn = true;
	protected E deleteReturn;
	
	public E find(E target)
	{
		return find(target, root);
	}
	public boolean add(E item)
	{
		if (root == null)
		{
			root = new Node(item);
			return true;
		}
		root = add(item, root);
		return addReturn;
	}
	public E findLargest()
	{
		return findLargest();
	}
	
	
	
	private E find(E target, Node<E> start)
	{
		if(start == null)
			return null;
		
		int result = target.compareTo(start.data);
		if(result == 0)
			return start.data;
		if(result < 0)
			return find(target, start.left);
		return find(target, start.right);
	}
	
	/*
	private Node<E> findLargestChild(Node<E> start)
	{
		if (start.right.right == null)
			return start.right;
		return findLargestChild(start.right);
		
	}
	*/
	
	public E delete(E target)
	{
		root = delete(root, target);
		return deleteReturn;
	}
	private Node<E> delete(Node<E> localRoot, E target)
	{
		if(localRoot == null)
		{
			deleteReturn = null;
			return localRoot;
		}
		int compResult = target.compareTo(localRoot.data);
		if(compResult<0)
		{
			localRoot.left = delete(localRoot.left, target);
			return localRoot;
		}
		if(compResult>0)
		{
			localRoot.right = delete(localRoot.left, target);
			return localRoot;
		}

		deleteReturn = localRoot.data;
		if(localRoot.left == null)
		{
			return localRoot.right;
		}
		if(localRoot.right== null)
		{
			return localRoot.left;
		}
		if(localRoot.left.right==null)
		{
			localRoot.data = localRoot.left.data;
			localRoot.left = localRoot.left.left;
			return localRoot;
		}
		localRoot.data = findLargestChild(localRoot.left);
		return localRoot;
	}
	
	private E findLargestChild(Node<E> parent)
	{
		if(parent.right.right ==null)
		{
			E returnVal = parent.right.data;
			parent.right = parent.right.left;
			return returnVal;
		}
		return findLargestChild(parent.right);
	}
	
	private E deleteLargestChild(Node<E> start)
	{
		E result;
		if (start.right.right == null)
		{
			result = start.right.data;
			start.right = start.right.left;
			return result;
		}
		return deleteLargestChild(start.right);
	}
	
	private Node<E> add(E item, Node<E> start)
	{
		if(start == null)
			return new Node<E>(item);
		int result = item.compareTo(start.data);
		if(result == 0)
		{
			addReturn = false;
			return start;
		}
		if(result < 0)
		{
			start.left = add(item, start.left);
			return start.left;
		}
		else
		{
			start.right = add(item, start.right);
			return start.right;
		}
	}
	
	
}
