package isu.edu;

import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String temp;
		Scanner num;
		do
		{
			System.out.println("Enter ID");
			temp = scan.nextLine();
			num = new Scanner(temp);
		}while(!num.hasNextInt());
		
	}

}
