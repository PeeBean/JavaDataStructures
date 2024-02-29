package ilstu.edu;

public class MainClass 
{
	public static void main(String[] args) 
	{
		BST<Integer> tree = new BST<>();
		tree.add(10);
		tree.add(2);
		tree.add(4);
		tree.add(6);
		tree.add(12);
		tree.add(15);
		tree.add(16);
		
		System.out.println(tree.toString());
	}

}
