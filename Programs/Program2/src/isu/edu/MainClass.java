package isu.edu;

/*
 * Main Class 
 * @author Bennett Beltran
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) 
	{
		ArrayList<Patient> arr = new ArrayList<Patient>();
		Scanner scan = new Scanner(System.in);
		String input, temp;
		Patient p;
		boolean done = false;
		boolean found = false; 
		Scanner num;
		int theID;
		
		do
		{
			System.out.println("Select one of the following:");
			System.out.println("	1. Enter 'Admit' or 'a' to admit a patient");
			System.out.println("	2. Enter 'Print' or 'p' to print patient infomation");
			System.out.println("	3. Enter 'Submit' or 's' to submit a PCR test result");
			System.out.println("	4. Enter 'Rounds' or 'r' to do rounds");
			System.out.println("	5. Enter 'Discharge' or 'd' to discharge a patient");
			System.out.println("	6. Enter 'Exit' or 'e' to exit");
			
			input = scan.nextLine();
			if(input.equals("Exit")  || input.equals("e") || input.equals("exit") || input.equals("E"))
			{
				done = true;
			}
			
			switch(input)
			{
				case "Admit":
				case "admit":
				case "A":
				case "a":
					System.out.println("Is patient's PCR test result negative or positive? Enter n if negative or p if positive");
					temp = scan.nextLine();
					if(temp.equals("n") || temp.equals("N") || temp.equals("negative") || temp.equals("Negative"))
					{
						int id, age;
						String fName, lName, symp;
						do
						{
							System.out.println("Enter ID (Needs to be a valid int)");
							temp = scan.nextLine();
							num = new Scanner(temp);
						}while(!num.hasNextInt());
						id = Integer.parseInt(temp);
						System.out.println("Enter first name");
						fName = scan.nextLine();
						System.out.println("Enter last name");
						lName = scan.nextLine();
						do
						{
							System.out.println("Enter age (Needs to be a valid int)");
							temp = scan.nextLine();
							num = new Scanner(temp);
						}while(!num.hasNextInt());
						age = Integer.parseInt(temp);
						System.out.println("Enter main symptom");
						symp = scan.nextLine();
						p = new RegularPatient(id, fName, lName, age, symp);
						p.setPcr(false);
						arr.add(p);
						
					}
					else if(temp.equals("p") || temp.equals("P") || temp.equals("positive") || temp.equals("Positive"))
					{
						int id, age;
						String fName, lName;
						double temperature;
						do
						{
							System.out.println("Enter ID (Needs to be a valid int)");
							temp = scan.nextLine();
							num = new Scanner(temp);
						}while(!num.hasNextInt());
						id = Integer.parseInt(temp);
						System.out.println("Enter first name");
						fName = scan.nextLine();
						System.out.println("Enter last name");
						lName = scan.nextLine();
						do
						{
							System.out.println("Enter age (Needs to be a valid int)");
							temp = scan.nextLine();
							num = new Scanner(temp);
						}while(!num.hasNextInt());
						age = Integer.parseInt(temp);
						
						do
						{
							System.out.println("Enter temperature (Needs to be a valid double)");
							temp = scan.nextLine();
							num = new Scanner(temp);
						}while(!num.hasNextDouble());
						temperature = Double.parseDouble(temp);
						
						p = new Covid19Patient(id, fName, lName, age, temperature);
						p.setPcr(true);
						arr.add(p);
					}
					else
						System.out.println("Error. Invalid Input");
					break;
				case "Print":
				case "print":
				case "P":
				case "p":
					do
					{
						System.out.println("Enter Patient's ID (Needs to be a valid int)");
						temp = scan.nextLine();
						num = new Scanner(temp);
					}while(!num.hasNextInt());
					theID = Integer.parseInt(temp);
					for(int i = 0; i < arr.size(); i++)
					{
						if(arr.get(i).getId() == theID)
						{
							System.out.println(arr.get(i).toString());
							found = true;
							break;
						}
					}
					if(!found)
						System.out.println("Error. Patient ID not found");
					break;
				case "Submit":
				case "submit":
				case "S":
				case "s":
					do
					{
						System.out.println("Enter Patient's ID (Needs to be a valid int)");
						temp = scan.nextLine();
						num = new Scanner(temp);
					}while(!num.hasNextInt());
					theID = Integer.parseInt(temp);
					for(int i = 0; i < arr.size(); i++)
					{
						if(arr.get(i).getId() == theID)
						{
							System.out.println("Enter p to update PCR test value to positive or enter n to update PCR value to negative");
							String s = scan.nextLine();
							double theTemp;
							if(s.equals("p") || s.equals("P"))
							{
								Patient pat = arr.get(i);
								do
								{
									System.out.println("Enter temperature (Needs to be a valid double)");
									temp = scan.nextLine();
									num = new Scanner(temp);
								}while(!num.hasNextDouble());
								theTemp = Double.parseDouble(temp);
								arr.set(i,new Covid19Patient(pat.getId(),pat.getfName(),pat.getlName(),pat.getAge(), theTemp));
							}
							else if(s.equals("N") || s.equals("n"))
							{
								if(arr.get(i) instanceof Covid19Patient)
								{
									arr.remove(i);
								}
								
							}
							else
								System.out.print("Error. Invalid Input");
							found = true;
							break;
						}
					}
					if(!found)
						System.out.println("Error. Patient ID not found");
					break;
				case "Rounds":
				case "rounds":
				case "R":
				case "r":
					for(Patient i: arr)
					{
						if(i instanceof Covid19Patient)
						{
							do
							{
								System.out.println("Enter patient temp (Needs to be a valid double)");
								temp = scan.nextLine();
								num = new Scanner(temp);
							}while(!num.hasNextDouble());
							((Covid19Patient)i).setTemp(Double.parseDouble(temp));
						}
					}
					for(Patient i: arr)
					{
						i.treat();
						System.out.println(i.toString());
					}
					break;
				case "Discharge":
				case "discharge":
				case "D":
				case "d":
					do
					{
						System.out.println("Enter Patient's ID (Needs to be a valid int)");
						temp = scan.nextLine();
						num = new Scanner(temp);
					}while(!num.hasNextInt());
					theID = Integer.parseInt(temp);
					
					found = false;
					for(int i = 0; i < arr.size(); i++)
					{
						if(arr.get(i).getId() == theID)
						{
							if(!arr.get(i).getPcr())
								arr.remove(i);
							else
								System.out.println("Error. Patient still has positive PCR test result");
							found = true;
						}
					}
					if(!found)
						System.out.println("Error. Patient ID not found");
					break;
				default:
					break;
			}
		} while (!done);
	}

}
