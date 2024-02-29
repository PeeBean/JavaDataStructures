package ilstu.edu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game Class
 * Provides Double linked list of Square objects that make up the games track.
 * Contains inner class Square.
 * @author Bennett_Beltran
 * 
 */
public class Game 
{
	/**
	 * Inner Square Class
	 * Used to make game track and to store player data.
	 */
	private static class Square
	{
		private Square prev;
		private Square next;
		private int num;
		private int jumpVal;
		
		public Square(int num, int jumpVal, Square prev)
		{
			this.num = num;
			this.jumpVal = jumpVal;
			this.prev = prev;
		}
	}
	private Square start;
	private ArrayList<Square> players;
	private int curP;
	
	
	/**
	 * Class constructor using an integer to initialize the players and linked list that makes up the game track.
	 * @param numP  the integer that corresponds to the amount of players for the game.
	 */
	public Game(int numP)
	{
		start = new Square(1, 0, null);
		players = new ArrayList<Square>(numP);
		Square curr = start;
		
		for(int i = 0; i < numP; i++)
		{
			players.add(start);
		}
		for(int i = 2; i <= 100; i++)
		{
			curr.next = new Square(i, getJumpVal(i), curr);
			curr = curr.next;
		}
		
	}
	
	/**
	 * Advances through actual game process and prints out the Current player and their roll.
	 */
	public void play()
	{
		boolean done = false;
		Scanner scan = new Scanner(System.in);
		String input;
		curP = 1;
		
		while(!done)
		{
			System.out.println("Player " + curP + " press any key to roll the die");
			input = scan.nextLine();
			int roll = (int) ((Math.random() * (6)) + 1);
			System.out.println("Player " + curP + " you rolled a " + roll);
			if(move(curP,roll))
				done = true;
			System.out.println();
			curP = (curP % players.size()) + 1;
		}
	}
	
	
	/**
	 * Moves Square object from corresponding players array list, through the linked list.
	 * The number for the current player is printed along with their starting position and ending position, including any jumps.
	 * @param pNum   the integer that corresponds to the current player.
	 * @param moves  the integer that dictates how many spots the player will move (IE. how many squares the player will traverse through).
	 * @return 	     <code>true</code> if the current player reaches square 100;
	 *               <code>false</code> otherwise.
	 */
	public boolean move(int pNum, int moves)
	{
		//Traverses current player through linked list based on what dice roll was passed into the moves integer.
		Square curr = players.get(pNum-1);
		System.out.println("Player " + pNum + " your start position was " + curr.num);
		for(int i =0; i < moves && curr.num != 100; i++)
		{
			curr = curr.next;
		}
		
		//Win condition.
		if(curr.num == 100)
		{
			System.out.println("and your end position is 100");
			System.out.println("Congrats Player " + pNum + " You win!");
			return true;
		}
		
		//Traverses player again based on jump value of the current square the player is referencing.
		int jump = curr.jumpVal;
		if(jump > 0)
		{
			for(int i =0; i < jump && curr.num != 100; i++)
				curr = curr.next;
		}
		else
		{
			for(int i = 0; i > jump && curr.prev !=null; i--)
				curr = curr.prev;
		}
		if(curr.num == 100)
		{
			System.out.println("and after your jump of " + jump + " from position " + (curr.num-jump) + " your end position is 100");
			System.out.println("Congrats Player " + pNum + " You win!");
			return true;
		}
		
		if(jump == 0)
			System.out.println("and your end position is " + curr.num);
		else if (jump < 0)
			System.out.println("and after your slide of " + jump + " from position " + (curr.num-jump) + " your end position is " + curr.num);
		else
			System.out.println("and after your jump of " + jump + " from position " + (curr.num-jump)+ " your end position is " + curr.num);
		
		players.set(pNum-1, curr);
		return false;
	}
	
	/**
	 * Calculates a random jump value.
	 * 75% of the time jump value will be 0.
	 * 12.5% of the time the jump value will be a random positive value, that stays within track limits.
	 * 12.5% of the time the jump value will be a random negative value, that stays within track limits.
	 * @param loc  the integer that corresponds to the position of a given square within the linked list.
	 * @return     the randomly assigned integer value which is either 0, positive, or negative.
	 */
	private int getJumpVal(int loc)
	{
		if( (int) (Math.random() * (100)) >= 25)
			return 0;
		else
		{
			if ( (int)(Math.random() * (100)) < 50)
				return (int) ((Math.random() * (100 - loc)) + 1);
			else
				return -1 * (int) ((Math.random() * (loc-1)) + 1);
		}
	}
	
	
}
