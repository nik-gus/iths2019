package model;

public class Nurse extends Employee {

	//NURSE SPECIFIC FIELDS??
	
		public Nurse(String name, String telNo, double salary) {
			super(name, telNo, salary);
		}

		@Override
		public void permanentEmploymentRaise() {
			salary += 2000;
		}
		
		@Override
		public String toString() {
			return super.toString() +"\nOccupation: Nurse";
		}
}
