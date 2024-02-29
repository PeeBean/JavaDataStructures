package ilstu.edu;

public class MainClass 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String s = "testing";
		int[] array = {1, 2, 3, 5, 6, 8, 420};
		System.out.println(binarySearch(array, 12));
		System.out.println(fib(45));
		System.out.println(showMoves(8,'L', 'R', 'M'));
		printRev(s);
	}

	
	public static int count(String val)
	{
		if(val==null || val.equals(""))
			return 0;
		return 1+count(val.substring(1));
	}
	
	public static void print(String val)
	{
		if(val==null || val.equals(""))
			return;
		System.out.print(val.charAt(0));
		print(val.substring(1));
	}
	public static void printRev(String val)
	{
		if(val==null || val.equals(""))
			return;
		print(val.substring(1));
		System.out.print(val.charAt(0));
	}
	
	public static int fact(int i)
	{
		if(i == 1 || i ==0)
			return 1;
		return i * fact(i - 1);
	}
	public static int power(int x, int n)
	{
		if(n == 0)
			return 1;
		return x * power(x, n-1);
	}
	
	/*
	public static int fib(int n)
	{
		if(n<=2)
			return 1;
		return fib(n-1) + fib(n-2);
	}
	*/
	
	public static int fib(int n)
	{
		return fibo(1,1,n);
	}
	private static int fibo(int fibCurr, int fibPrev, int n)
	{
		if(n==1)
			return fibCurr;
		return fibo(fibCurr + fibPrev, fibCurr, n-1);
	}
	
	public static String removeDup(String word)
	{
		if(word == "" || word == null || word.length()==1)
			return word;
		if(word.charAt(0) == word.charAt(1))
			return removeDup(word.substring(1));
		return word.charAt(0) + removeDup(word.substring(1));
	}
	
	
	//Towers of Hanoi
	public static String showMoves(int n, char start, char dest, char temp)
	{
		if (n==1)
			return "move disk 1 from " + start + " to " + dest;
		return showMoves(n-1, start, temp, dest) + 
				"\nmove disk " + n + " from " + start + " to " + dest + 
				"\n" + showMoves(n-1, temp, dest, start);
	}
	
	
	
	
	public static int countChar(String word, char letter)
	{
		if(word == null)
			return 0;
		if(word.charAt(0) == letter)
			return 1 + countChar(word.substring(1), letter);
		return countChar(word.substring(1), letter);
	}
	
	
	public static int binarySearch(int[] array, int target)
	{
		return binarySearch(array, target, 0, array.length-1);
	}
	private static int binarySearch(int[] array, int target, int start, int end)
	{
		int pos = (start+end)/2;
		if(start>end)
			return -1;
		if(array[pos] == target)
			return pos;	
		if(target > array[pos])
			return binarySearch(array, target, pos+1, end);
		return binarySearch(array, target, start, pos-1);
		
	}

	
	public static int search(Object[] array, Object target)
	{
		return search(array, target, 0);

	}
	private static int search(Object[] array, Object target, int pos)
	{
		if(pos == array.length)
			return -1;
		if(array[pos].equals(target))
			return pos;
		return search(array, target, pos+1);
	}
	
	
}
