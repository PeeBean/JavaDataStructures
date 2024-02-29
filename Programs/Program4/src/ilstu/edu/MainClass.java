package ilstu.edu;

import java.util.Scanner;

/**
 * MainClass Class
 * Allows user input to execute Chutes and Ladders game.
 * @author Bennett_Beltran
 */
public class MainClass 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		int players = 0;
		
		System.out.println("Hi welcome to Chutes and Ladders");
		do
		{
			try 
			{
				System.out.println("How many players? (Must be a positive int)");
				players = Integer.parseInt(scan.nextLine());
				if(players > 0)
					done = true;
			} catch(NumberFormatException e)
			{
				System.out.println("Invalid Input");
			}
		} while(!done);
		Game g = new Game(players);
		g.play();
	}
}
