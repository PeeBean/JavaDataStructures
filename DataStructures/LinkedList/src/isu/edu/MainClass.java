package isu.edu;

public class MainClass 
{
	public static void main(String[] args)
	{
		SingleList<String> list = new SingleList<String>();
		
		list.add("Burger");
		list.add("ceese");
		list.add("apple");
		list.addAfterEvens("fries");
	
		list.print();
		/*
		 Traversing a linked list:8
		 Node<E> temp = list.head;
		 while(temp!=null)
		 {
		 	//Access temp
		 	//ex System.out.println(temp.data);
		 	 temp = temp.next;
		 }
		 
		 */
		System.out.println("List2: \n");
		SingleList<String> list2 = list.getReverse();
		list2.print();
		
	}
	public static int sum(int a, int b)
	{
		return a+b;
	}
}
