package model;

public class Doctor extends Employee {

	//DOCTOR SPECIFIC FIELDS??
	
	public Doctor(String name, String telNo, double salary) {
		super(name, telNo, salary);
	}

	@Override
	public void permanentEmploymentRaise() {
		salary += 5000;
	}
	
	@Override
	public String toString() {
		return super.toString() +"\nOccupation: Doctor";
	}

	
	
} //end class