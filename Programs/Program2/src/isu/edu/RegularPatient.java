package isu.edu;

/* Main Class 
* @author Bennett Beltran
*/

public class RegularPatient extends Patient
{
	private String mainSymptom;
	
	public RegularPatient(int id, String fName, String lName, int age, String mainSymptom) 
	{
		super(id, fName, lName, age);
		this.mainSymptom = mainSymptom;
	}

	public String treat()
	{
		switch(this.mainSymptom)
		{
			case "coughing":
			case "runny nose":
			case "stuffy nose":
				return "Amoxicillin";
			case "hypertension":
				return "ACE Inhibitors";
			default:
				return "IV fluids";
		}
	}
	public String toString()
	{
		String result = "ID: " + this.getId() + "\nFull name: " + this.getfName() + " " + this.getlName()
		+ "\nAge: " + this.getAge() + "\nMain Symptom: " + this.mainSymptom + "\nPCR Test Result: ";
		if(this.getPcr() == true)
			result += "Positive";
		else
			result += "Negative";
		result += "\nTreatment: " + this.treat();
		return result;
	}
}
