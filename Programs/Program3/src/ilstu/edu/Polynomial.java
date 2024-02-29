package ilstu.edu;

/*
 * Polynomial Class
 * Singly Linked list of Term objects
 * Includes inner Class Node
 * @author Bennett Beltran
 */
public class Polynomial 
{
	private Node termsHead;
	private Node termsTail;
	private int size;
	
	/**
	 * Default Constructor.
	 */
	public Polynomial(){}
	
	/**
	 * Class Constructor using String to create linked lists of terms that make up the polynomial.
	 * 
	 * @param  pol  the string that is converted into terms that are then added to the linked list.
	 */
	public Polynomial(String pol)
	{
		int coef=0;
		int exp=0;
		String temp;
		boolean done = false;
		
		while(!done)
		{
			pol = pol.trim();
			if(!pol.contains("x"))
			{
				coef = Integer.parseInt(pol);
				exp = 0;
				done = true;
			}
			else
			{
				temp = pol.substring(0,pol.indexOf("x"));
				if(temp.contains("-"))
				{
					temp = temp.substring(temp.indexOf("-")+1);
					coef = Integer.parseInt(temp)*-1;
				}
				else
					coef = Integer.parseInt(temp);
				if(!pol.contains(" -")&& !pol.contains("+"))
				{
					if(pol.indexOf("x^")==-1)
						temp = "1";
					else
						temp = pol.substring(pol.indexOf("x")+2);
					done = true;
				}
				else if((pol.indexOf("+") < pol.indexOf(" -") && pol.contains("+") && pol.contains(" -")) || (pol.contains("+") && !pol.contains(" -")))
				{
					if(pol.indexOf("x^")==-1)
						temp = "1";
					else
						temp = pol.substring(pol.indexOf("x")+2, pol.indexOf(" +"));
					pol = pol.substring(pol.indexOf("+")+1);
				}
				else
				{
					if(pol.indexOf("x^")==-1)
						temp = "1";
					else
						temp = pol.substring(pol.indexOf("x")+2, pol.indexOf(" -"));
					pol =  "-" + pol.substring(pol.indexOf(" -")+3);
				}
				exp = Integer.parseInt(temp);
			}
			Term term = new Term(coef, exp);
			addTermToPolynomial(term);
		}
		
	}
	
	/**
	 * Goes through linked list and formats terms to represent a polynomial.
	 * 
	 * @return  the formatted polynomial as a String
	 */
	public String toString()
	{
		Node temp = termsHead;
		String result = "";
		if(temp!=null)
		{
			if(temp.termData.getCoefficient()==0)
			{}
			else if(temp.termData.getExponent()==0)
				result += temp.termData.getCoefficient();
			else if(temp.termData.getExponent()==1)
				result += temp.termData.getCoefficient() +"x";
			else
				result += temp.termData.getCoefficient() + "x^" + temp.termData.getExponent(); 
			temp = temp.next;
		}
		while(temp!=null)
		{
			if(temp.termData.getExponent()==0 && temp.termData.getCoefficient() < 0)
				result += " ";
			else if(temp.termData.getCoefficient() > 0)
				result += " + ";
			else if(temp.termData.getCoefficient() < 0)
				result += " - ";
				
			if(temp.termData.getCoefficient()==0)
			{}
			else if(temp.termData.getExponent()==0)
				result += temp.termData.getCoefficient();
			else if(temp.termData.getExponent()==1)
				result += temp.termData.getCoefficient() +"x";
			else
				result += temp.termData.toString();
			temp = temp.next;
		}
		return result;
	}
	
	/**
	 * Adds the terms from each polynomial to create the resulting Polynomial object.
	 * @param  poly  the polynomial that is to be added to the current polynomial
	 * @return	     the resulting polynomial as a Polynomial objects
	 */
	public Polynomial addPolynomial(Polynomial poly)
	{
		Polynomial result = new Polynomial();
		Polynomial sums = new Polynomial();
		Node pol1 = termsHead;
		Node pol2 = poly.termsHead;
		Node temp;
		Node curr;
		boolean match;
		
		//Stores the sums of all terms with the same exponents in the sums Polynomial object
		while(pol1 !=null)
		{
			pol2 = poly.termsHead;
			while(pol2 !=null)
			{
				if(pol1.termData.getExponent()==pol2.termData.getExponent())
				{	
					sums.addTermToPolynomial(new Term(pol1.termData.getCoefficient()+ pol2.termData.getCoefficient(),pol1.termData.getExponent()));
				}
				pol2 = pol2.next;
			}
			pol1 = pol1.next;
		}	
		pol1 = termsHead;
		
		/*
		 * Determines if the terms present in Polynomial 1 are also present in sums
		 * Then the terms that are not present in sums are added to the result Polynomial
		 */
		while(pol1 !=null)
		{
			match = false;
			temp = sums.termsHead;
			while(temp!=null && !match)
			{
				if(pol1.termData.getExponent()==temp.termData.getExponent())
					match =true;
				temp = temp.next;
			}
			if(!match)
				result.sortedAdd(pol1);
			pol1 = pol1.next;
		}
		pol2 = poly.termsHead;
		
		/*
		 * Determines if the terms present in Polynomial 2 are also present in sums
		 * Then the terms that are not present in sums are added to the result Polynomial
		 */
		while(pol2 !=null)
		{
			match = false;
			temp = sums.termsHead;
			while(temp!=null && !match)
			{
				if(pol2.termData.getExponent()==temp.termData.getExponent())
					match =true;
				temp = temp.next;
			}
			if(!match)
				result.sortedAdd(pol2);
			pol2 = pol2.next;
		}
		
		//Adds Terms to final list that had the same exponents and were added previously 
		temp = sums.termsHead;
		while(temp!=null)
		{
			result.sortedAdd(temp);
			temp = temp.next;
		}
		return result;
	}
	
	/**
	 * Adds a node to the begging of linked list.
	 * @param item  the data given to the added node
	 */
	private void addFirst(Term item)
	{
		termsHead = new Node(item, termsHead);
		size++;
	}
	/**
	 * Adds a node after given node in linked list.
	 * @param node  the node that will point to the new node so, the node before the new node
	 * @param item  the data given to the added node
	 */
	private void addAfter(Node node, Term item)
	{
		node.next = new Node(item, node.next);
		size++;
	}
	/**
	 * Adds node to the end of the linked list. 
	 * Does not add node if the Term's coefficient is 0
	 * @param item  the data given to the added Term
	 */
	public void addTermToPolynomial(Term item)
	{
		if(termsHead == null)
			addFirst(item);
		else
		{
			Node current = termsHead;
			while(current.next!=null)
				current = current.next;
			addAfter(current, item);
		}
	}
	/**
	 * Adds a node to the linked list in accordance to the Term's exponent size.
	 * @param head  the node at the beginning of the linked list containing terms to be added
	 */
	private void sortedAdd(Node head)
	{
		Node temp = head;
		Node curr = termsHead;
		if(curr==null)
			addTermToPolynomial(new Term(temp.termData.getCoefficient(),temp.termData.getExponent()));
		else
		{
			if(curr.termData.getExponent()<temp.termData.getExponent())
				addFirst(new Term(temp.termData.getCoefficient(),temp.termData.getExponent()));
			else
			{
				while(curr.next!=null && curr.next.termData.getExponent()>temp.termData.getExponent())
					curr = curr.next;
				addAfter(curr, new Term(temp.termData.getCoefficient(),temp.termData.getExponent()));
			}
		}
	}

	/**
	 * Inner Node Class.
	 * Used to make singly linked list.
	 */
	private class Node
	{
		Term termData;
		Node next;
		
		public Node(Term termData)
		{
			this.termData = termData;
		}
		public Node(Term termData, Node next)
		{
			this.termData = termData;
			this.next = next;
		}
	}
}

