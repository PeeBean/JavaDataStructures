package isu.edu;

/* Main Class 
* @author Bennett Beltran
*/

public class Covid19Patient extends Patient
{
	private double temperature;
	
	
	public Covid19Patient(int id, String fName, String lName, int age, double temperature) 
	{
		super(id, fName, lName, age);
		this.temperature = temperature;
	}


	public double getTemp() {
		return temperature;
	}
	public void setTemp(double temperature) {
		this.temperature = temperature;
	}
	
	public String treat()
	{
		if(this.getAge()>64 && this.getTemp()>37.5)
		{
			return "Remdesivir";
		}
		else if(this.getTemp()>41)
		{
			return "Dexamethasone";
		}
		else
			return "Fluids and Tylenol";
	}
	public String toString()
	{
		String result = "ID: " + this.getId() + "\nFull name: " + this.getfName() + " " + this.getlName()
		+ "\nAge: " + this.getAge() + "\nPCR Test Result: ";
		if(this.getPcr() == true)
			result += "Positive";
		else
			result += "Negative";
		result += "\nTreatment: " + this.treat();
		return result;
	}
}
