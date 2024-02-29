package ilstu.edu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MainClass Class
 * Creates binary tree containing characters and allows user input of '.''s and '-',s to decode morse code.
 * @author Bennett Beltran
 */
public class MainClass 
{
	static MorseTree m = buildTree("test.txt");
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		boolean valid = false;
		boolean done = false;
		String input;

		while(!done)
		{
			do
			{
				System.out.println("Please enter encoded message or 'stop' to exit:");
				input = scan.nextLine();
				
				if(input.equals("stop"))
				{
					done = true;
					valid = false;
					break;
				}
				
				for(int i = 0; i < input.length(); i++)
				{
					if(!(input.charAt(i)== '-' || input.charAt(i)== '.' || input.charAt(i)== ' '))
					{
						valid = false;
						break;
					}
					else
						valid = true;
				}
				if(valid == false)
					System.out.println("Please enter a valid Morse Code!");

			} while(!valid);

			if(valid)
				System.out.println("The decoded message is: " + decode(input));

		}
		
		System.out.println("Thank you for using our decoder!");
	}
	
	/**
	 * Constructs actual binary tree using given filename containing characters and their morse code equivalent. 
	 * @param fileName  the String containing the name of the file which contains characters and their morse code equivalent.
	 * @return  	    the constructed binary tree.
	 */
	public static MorseTree buildTree(String fileName) 
	{
		File file = new File(fileName);
		MorseTree m = new MorseTree();
		
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine()) 
			{
				Scanner line = new Scanner(in.nextLine());
				while(line.hasNext())
				{
					String temp = line.next();
					char letter = temp.charAt(0);
					String code = temp.substring(1);
					m.add(letter, code);
				}	
			}
		} catch (FileNotFoundException err)
		{
			System.out.println("File not found");
		}
		return m;
	}

	/**
	 * Takes in a String containing morse code and decodes each sequence into the corresponding letter.
	 * @param code  a String containing morse code.
	 * @return      the decoded String of letters.
	 */
	public static String decode(String code)
	{
		Scanner line = new Scanner(code);
		String result = "";
		
		while(line.hasNext())
		{
			String temp = line.next();
			result = result + m.decode(temp);
		}
		
		return result;
	}
	
}
