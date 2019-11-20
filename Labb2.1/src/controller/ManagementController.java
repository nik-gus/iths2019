package controller;
///test test update test
import java.time.LocalDate;
import java.util.HashMap;
import java.util.InputMismatchException;

import app.Application;
import model.Doctor;
import model.Employee;
import model.EmployeeRegister;
import model.Nurse;
import model.Receptionist;
import utilities.EmploymentStatus;
import view.ManagementUI;

public class ManagementController {
	private ManagementUI mUI;
	private HashMap<Integer, Employee> empMap;

	public ManagementController(EmployeeRegister empRec, ManagementUI ui) {
		this.mUI = ui;
		empMap = empRec.getEmpMap();
	}

	public void employeeManagement() {
		Employee emp;
		int choice;
		mUI.showManagementMenu();
		try {
			choice = Application.sc.nextInt(); 
		} catch (InputMismatchException e) {
			choice = 99;
		}
		Application.sc.nextLine();
		switch (choice) {
		case 0:
			break;
		case 1: 
			int empType = mUI.askForEmpType();
			if (empType == 1) {
				emp = new Doctor(mUI.askForName(), mUI.askForTelNo(), mUI.askForSalary());
			}
			else if (empType == 2) {
				emp = new Nurse(mUI.askForName(), mUI.askForTelNo(), mUI.askForSalary());
			}
			else if (empType == 3) {
				emp = new Receptionist(mUI.askForName(), mUI.askForTelNo(), mUI.askForSalary());
			}
			else {
				System.out.println("Fel inmatning");
				break;
			}
			addEmployee(emp);
			break;
		case 2: 
			deleteEmployee(mUI.askForID());
			break;
		case 3:
			updateName(mUI.askForID(), mUI.askForName());
			break;
		case 4:
			updateSalary(mUI.askForID(), mUI.askForSalary());
			break;
		case 5:
			printEmployeesByName(mUI.askForName());
			break;
		case 6:
			mUI.printEmployee(getEmployeeByID(mUI.askForID()));
			break;
		case 7:
			printAllEmployees();
			break;
		case 8:
			printAllDoctors();
			break;
		case 9:
			checkSalaryRaise();
			break;
		case 10:
			emp = getEmployeeByID(mUI.askForID());
			if (emp != null) {
				emp.setEmploymentDate(LocalDate.parse(mUI.askForDate())); //<---  java.time.format.DateTimeParseException
			}
			break;
			/* nedan: exempel på hur man lägger till ny funktionalitet med 1 rad kod */
		//case 11: getEmployeeByID(mUI.askForID()).setStatus(EmploymentStatus.PERMANENT);
		//break;
		default:
			break;
		}
	}

	public void addEmployee(Employee emp) {
		empMap.put(emp.getEMPID(), emp);
	}

	public void deleteEmployee(int empID) {
		empMap.remove(empID);
	}

	public void updateName(int empID, String name) {
		empMap.get(empID).setName(name);
	}

	public void updateSalary(int empID, double salary) {
		empMap.get(empID).setSalary(salary);
	}

	public Employee getEmployeeByID(int id) {
		return empMap.get(id);
	}

	public void printEmployeesByName(String name) {
		for (Employee emp : empMap.values()) {
			if (emp.getName().equalsIgnoreCase(name)) {
				mUI.printEmployee(emp);
			}
		}
	}

	public void printAllEmployees() {
		for (Employee emp: empMap.values()) {
			mUI.printEmployee(emp);
		}
	}

	public void printAllDoctors() {
		for (Employee emp: empMap.values()) {
			if (emp instanceof Doctor) {
				mUI.printEmployee(emp);
			}
		}
	}

	/* 
	 * Method checks employee register for employees with probationary status that has been employed for at least six months.
	 * Updates status and gives a salary raise.
	 */
	public void checkSalaryRaise() {
		for (Employee emp : empMap.values()) {
			if ((emp.getStatus() == EmploymentStatus.PROBATIONARY) && emp.getEmploymentDate().plusMonths(6).isBefore(LocalDate.now())) {
				double oldSalary = emp.getSalary();
				emp.permanentEmploymentRaise();
				emp.setStatus(EmploymentStatus.PERMANENT);
				mUI.printSalaryChange(emp.getEMPID(), oldSalary, emp.getSalary());
			}
		}			
	}

	/*
	 * FOR PRESENTATION
	 */
	public void loadDemo() {
		addEmployee(new Doctor("Doctor1", "070-123 45 67", 40000));
		addEmployee(new Doctor("Doctor2", "070-765 43 21", 35000));
		addEmployee(new Nurse("Nurse1","070-555 55 55", 30000));
		addEmployee(new Nurse("Nurse2", "08-777 88 99", 30000));
		addEmployee(new Receptionist("Gittan","070- 333 44 55", 25000));
		addEmployee(new Receptionist("Ulla-Bella","08-888 88 88", 40000));

	}

} //end class
