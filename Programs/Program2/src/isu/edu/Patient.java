package isu.edu;

/* Main Class 
* @author Bennett Beltran
*/

public abstract class Patient 
{
	private int id;
	private String fName;
	private String lName;
	private int age;
	private boolean pcr;
	
	public Patient(int id, String fName, String lName, int age)
	{
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean getPcr() {
		return pcr;
	}
	public void setPcr(boolean pcr) {
		this.pcr = pcr;
	}
	
	
	
	public abstract String treat();
	
	public String toString()
	{
		return "";
	}
	
	
}
