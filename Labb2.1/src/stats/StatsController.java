package stats;

import java.util.InputMismatchException;
import java.util.List;

import app.Application;
import model.Doctor;
import model.Employee;
import model.EmployeeRegister;
import model.Nurse;
import utilities.EmploymentStatus;

public class StatsController {
	private StatsUI statsUI;
	private List<Employee> empList;

	public StatsController(EmployeeRegister empReg, StatsUI statsUI) {
		this.statsUI = statsUI;
		empList = empReg.getEmpList();
	}
	
	public void runStatistics() {
		int choice;
		statsUI.showStatsMenu();
		try {
		choice = Application.sc.nextInt();
		} catch (InputMismatchException e) {
			choice = 0;
		}
		Application.sc.nextLine();
		switch (choice) {
		case 0:
			break;
		case 1:
			getCompanySalaryAverage();
			break;
		case 2:
			getDoctorSalaryAverage();
			break;
		case 3:
			getMaxSalaryEmployees();
			break;
		case 4:
			getMinSalaryEmployees();
			break;
		case 5:
			getNursesOnProb();
			break;
		default: 
			break;
		}
	}
	
	public void getCompanySalaryAverage() {
		double sum = 0;
		for (Employee emp : empList) {
			sum += emp.getSalary();
		}
		statsUI.printCompanySalaryAverage(sum / empList.size()); 
	}

	public void getDoctorSalaryAverage() {
		double sum = 0;
		int noOfDoctors = 0;
		for (Employee emp : empList) {
			if (emp instanceof Doctor) {
			sum += emp.getSalary();
			noOfDoctors++;
			}
		}
		statsUI.printDoctorSalaryAverage(sum / noOfDoctors); //no casting needed?		
	}
	
	public void getMaxSalaryEmployees() {
		double max = 0;
		for (Employee emp : empList) {
			if (emp.getSalary() > max) {
				max = emp.getSalary();
			}
		}
		for (Employee emp : empList) {
			if (emp.getSalary() == max) {
				statsUI.printEmployee(emp);
			}
		}
	}
	
	public void getMinSalaryEmployees() {
		double min = empList.get(1).getSalary();
		for (Employee emp : empList) {
			if (emp.getSalary() < min) {
				min = emp.getSalary();
			}
		}
		for (Employee emp : empList) {
			if (emp.getSalary() == min) {
				statsUI.printEmployee(emp);
			}
		}
	}

	public void getNursesOnProb() {
		int noOfProbNurses = 0;
		int noOfPermNurses = 0;
		for (Employee emp : empList) {
			if (emp instanceof Nurse) {
				if (emp.getStatus() == EmploymentStatus.PROBATIONARY) {
					noOfProbNurses++;
				}
				else {
					if (emp.getStatus() == EmploymentStatus.PERMANENT) {
						noOfPermNurses++;
					}
				}
			}
		}
		double probNurses = (((double) noOfProbNurses / (noOfProbNurses + noOfPermNurses)) *100);
		statsUI.printNursesOnProb(probNurses);
	}
	
} //end class
