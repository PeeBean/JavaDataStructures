package ilstu.edu;

/**
 * MorseTree Class
 * Provides Binary tree that stores nodes with a letter and corresponding code.
 * Contains inner Node class.
 * @author Bennett Beltran
 */
public class MorseTree
{
	/**
	 * Inner Node Class
	 * Used to store a letter and its corresponding morse code, as well as references to two other nodes.
	 */
	private class Node
	{
		private char letter;
		private String code;
		private Node left;
		private Node right;
		
		/**
		 * Class Constructor
		 * @param letter  the char containing a letter of the alphabet
		 * @param code	  the corresponding morse code String
		 */
		public Node(char letter, String code)
		{
			this.letter = letter;
			this.code = code;
		}
	}
	
	protected Node root;
	
	/**
	 * Class Constructor
	 * Initializes root to be a node with no letter or code.
	 */
	public MorseTree()
	{
		root = new Node(' ', "");
	}
	
	/**
	 * adds a Node to the binary tree.
	 * @param letter  the char representing a letter of the alphabet.
	 * @param code	  the morse code equivalent of the given letter.
	 * @return	      <code>true</code> if node added successfully
	 * 				  <code>false</code> if not.
	 */
	public boolean add(char letter, String code)
	{
		String tempCode = code;
		return add(letter, root, code, tempCode);
	}
	/**
	 * Translates given code which is a String into the corresponding letter.
	 * @param code  morse code sequence as a String denoted with "."'s and "-"'s.
	 * @return		the letter equivalent of the morse code as a char.
	 */
	public char decode(String code)
	{
		return decode(root, code);
	}
	
	/**
	 * Helper method that adds a node to the tree using given code data to determine its location in the tree.
	 * @param letter    the char that represents the letter data within the node. 
	 * @param start	    the current node being considered.
	 * @param code		the String  representing the morse code data to be added to the node.
	 * @param tempCode  the current string being decoded.
	 * @return	        <code>true</code> if node added successfully
	 * 				    <code>false</code> if not.
	 */
	private boolean add(char letter, Node start, String code, String tempCode)
	{
		String temp = tempCode.substring(0,1);
		
		if(temp.equals("."))
		{
			if(start.left == null)
				start.left = new Node(letter, code);
			else
				add(letter, start.left, code, tempCode.substring(1));
		}
		else
		{
			if(start.right == null)
				start.right = new Node(letter, code);
			else
				add(letter, start.right, code, tempCode.substring(1));
		}
		return true;
	}
	/**
	 * Helper method that turns the given code String into its corresponding letter or ' ' if invalid code.
	 * @param start  the current node being considered.
	 * @param code   the String code to be translated.
	 * @return
	 */
	private char decode(Node start, String code)
	{
		if(start == null)
		{
			System.out.println("Invalid token");
			return ' ';
		}
		else
		{
			if(code.length() == 0)
				return start.letter;
			else if(code.substring(0,1).equals("."))
				return decode(start.left, code.substring(1));
			else
				return decode(start.right, code.substring(1));
		}
	}
	
}


