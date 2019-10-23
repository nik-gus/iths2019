package model;

public class Receptionist extends Employee {

	//RECEPTIONIST SPECIFIC FIELDS??
	
		public Receptionist(String name, String telNo, double salary) {
			super(name, telNo, salary);
		}

		@Override
		public void permanentEmploymentRaise() {
			salary += 1000;
		}
		
		@Override
		public String toString() {
			return super.toString() +"\nOccupation: Receptionist";
		}
}
