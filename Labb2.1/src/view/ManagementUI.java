package view;

import app.Application;
import model.Employee;

public class ManagementUI {

	public void showMainMenu() {
		System.out.println("\n---------- MAIN MENU ----------");
		System.out.println("1. Employee Management");
		System.out.println("2. Employee Statistics");
		System.out.println("3. Exit");
	}

	public void showManagementMenu() {
		System.out.println("\n---------- MANAGEMENT MENU ----------");
		System.out.println("1.  Register new employee");
		System.out.println("2.  Delete employee");
		System.out.println("3.  Update name of employee");		
		System.out.println("4.  Update Salary of employee");
		System.out.println("5.  List employee(s) by name");
		System.out.println("6.  View employee by employee ID");	
		System.out.println("7.  List all employees");
		System.out.println("8.  List all Doctors");
		System.out.println("9.  Check employment record for permanent employment raise");
		System.out.println("10. Update employment date of employee");
		System.out.println("0.  Back to main menu");
	}
	

	
	
/* USED BY MANAGEMENT */
	public void printSalaryChange(int empID, double oldSalary, double newSalary) {
		System.out.println("\nEmployee #" +empID +" got a raise from " 
				+String.format("%.2f", oldSalary) +" to " +String.format("%.2f", newSalary));
	}
	
	public void printEmployee(Employee emp) {
		if (emp != null) {
		System.out.println(emp.toString());
		} 
		else {
			System.out.println("No such Employee!");
		}
	}


	
	
	
	public int askForID() {
		System.out.println("Enter Employee ID:");
		int empID = Application.sc.nextInt();
		Application.sc.nextLine();
		return empID;
	}

	public String askForName() {
		System.out.println("Enter name:");
		return Application.sc.nextLine();
	}
	
	public String askForTelNo() {
		System.out.println("Enter telephone number:");
		return Application.sc.nextLine();
	}
	
	public double askForSalary() {
		System.out.println("Enter Salary:");
		double salary = Application.sc.nextDouble();
		Application.sc.nextLine();
		return salary;
	}
	public int ask(String s) {
		System.out.println(s);
		int num= Application.sc.nextInt();
		Application.sc.nextLine();
		return num;
		
	}
	public int askForEmpType() {
		System.out.println("Enter \n1. for Doctor: \n2. for Nurse: \n3. for Receptionist:");
		int empType = Application.sc.nextInt();
		Application.sc.nextLine();
		return empType;
	}
	
	public String askForDate() {
		System.out.println("Enter date (YYYY-MM-DD):");
		return Application.sc.nextLine();
	}

} //end class
