package stats;

import model.Employee;

public class StatsUI {

	public void showStatsMenu() {
		System.out.println("\n---------- STATS MENU ----------\n");
		System.out.println("1. Average wage at the company."); 
		System.out.println("2. Average wage for Doctors.");
		System.out.println("3. Employee(s) with highest salary in the company");
		System.out.println("4. Employee(s) with lowest salary in the company");
		System.out.println("5. Percentage of Nurses on probationary employment");
		System.out.println("0. Back to Main Menu");
	}
	
	public void printCompanySalaryAverage(double average) {
		System.out.println("\nSalary average is: " +String.format("%.2f", average));		
	}

	public void printDoctorSalaryAverage(double average) {
		System.out.println("\nDoctor salary average is: " +String.format("%.2f", average));
	}

	public void printNursesOnProb(double d) {
		System.out.println("\nPercentage of Nurses still on Probationary employment is " 
				+String.format("%.1f", d) +"%");
	}
	
	public void printEmployee(Employee emp) {
		if (emp != null) {
		System.out.println(emp.toString());
		} 
		else {
			System.out.println("No such Employee!");
		}
	}
}
