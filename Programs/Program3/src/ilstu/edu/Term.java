package ilstu.edu;

/*
 * Term Class
 * Comprised of integers representing a coefficient and exponent
 * @author Bennett Beltran
 */

public class Term 
{
	private int coefficient;
	private int exponent;
	
	/**
	 * Class Constructor using integers representing the coefficient and exponent to instantiate Term object.
	 * @param coefficient  the integer before x in a term
	 * @param exponent 	   the integer that x is to the power of
	 */
	public Term(int coefficient, int exponent)
	{
		this.coefficient = coefficient;
		this.exponent = exponent;
	}
	
	/**
	 * Returns integer coefficient from term.
	 * @return the integer coefficient
	 */
	public int getCoefficient() {
		return coefficient;
	}
	/**
	 * Returns integer exponent from term.
	 * @return the integer exponent
	 */
	public int getExponent() {
		return exponent;
	}
	
	/**
	 * Adds two terms together to create resulting term.
	 * @param t  the second term which is added to the initial term object
	 * @return the resulting Term object from the sum of the two terms
	 */
	Term addTerm(Term t)
	{
		if(exponent != t.exponent)
			return null;
		else
			return new Term(t.coefficient+coefficient, exponent);
	}
	/**
	 * Formats term data into typical form as a string.
	 * @return  the resulting formated string in (coefficient) * x ^ (exponent) form
	 */
	public String toString()
	{
		/*
		 * Absolute value of coefficient is used to make formatting
		 * of toString method in Polynomial class more simple
		 */
		return Math.abs(coefficient) + "x^" + exponent; 
	}
}
