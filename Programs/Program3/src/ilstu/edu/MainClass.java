package ilstu.edu;

/*
 * Main Class
 * Allows user input to add two polynomial objects together
 * @author Bennett Beltran
 */

import java.util.Scanner;

public class MainClass 
{
	public static void main(String[] args)
	{
		Polynomial p = new Polynomial();
		Polynomial p2 = new Polynomial();
		String input;
		String input2;
		boolean done = false;
		Scanner scan = new Scanner(System.in);

		try
		{
			do
			{
				System.out.println("Welcome to the Polynomial Addition Program.");
				System.out.println("Please enter your first polynomial: ");
				input = scan.nextLine();
				p = new Polynomial(input);
				System.out.println("Please enter the second polynomial: ");
				input2 = scan.nextLine();
				p2 = new Polynomial(input2);

				System.out.println("The sum is : " + p.addPolynomial(p2));
				System.out.println("\nWould you like to add two more polynomials? y = yes, n = no");
				input = scan.nextLine();
				if(input.equalsIgnoreCase("n"))
					done =true;
			}
			while(!done);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input");
		}
		System.out.println("Thank you for using the Polynomial Addition Program.");

	}
}
