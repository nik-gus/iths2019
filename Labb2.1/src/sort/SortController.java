package sort;

import java.util.Collections;
import java.util.Comparator;

import app.Application;
import model.Employee;
import model.EmployeeRegister;
import utilities.EmploymentStatus;

public class SortController {
	private EmployeeRegister empReg;
	private SortUI sortUI;

	public SortController(EmployeeRegister empReg, SortUI sortUI) {
		this.empReg = empReg;
		this.sortUI = sortUI;
	}

	public void runSort() {
		sortUI.showSortMenu();	
		int input;
		try {
			input = Integer.parseInt(Application.sc.nextLine());
		} catch (Exception e) {
			input = 0;
		} 
		switch (input) {
		case 0: 
			break;
		case 1:
			sortByName();
			printEmployeeList();
			break;
		case 2:
			sortByNameDescending();
			printEmployeeList();
			break;
		case 3:
			sortByTelNoDescending();
			printEmployeeList();
			break;
		case 4:
			sortUI.printPayout(calcAnnualPayout());
			break;
		case 5:
			printHighPayedNoobs();
			break;
		case 6:
			printPhoneBook();
		default: 
			break;
		}

	}

	public void sortByName() {
		Collections.sort(empReg.getEmpList());
	}

	public void sortByNameDescending() {
		Collections.sort(empReg.getEmpList(), new NameDescendingComparator());
	}

	public void sortByTelNoDescending() {
		Collections.sort(empReg.getEmpList(), (e1, e2) -> -((e1.getTelNo()).compareTo(e2.getTelNo())));
	}

	public void printEmployeeList() {
		for (Employee e : empReg.getEmpList()) {
			sortUI.printEmployee(e);
		} 
	}

	public double calcAnnualPayout() {
		double payout = 
				empReg.getEmpList().stream()		
				.mapToDouble(Employee::getSalary)
				.map(s -> s*12)
				.sum();
		return payout;
	}
	
	public void printHighPayedNoobs() {
		empReg.getEmpList().stream()
		.filter(emp -> emp.getSalary() >= 35000.0)
		.filter(emp -> emp.getStatus() == EmploymentStatus.PROBATIONARY)
		.forEach(sortUI::printEmployee);
	}
	
	public void printPhoneBook() {
		empReg.getEmpList().stream()
		.sorted(Comparator.comparing(Employee::getName))
		.forEach(s -> sortUI.printPhoneBookEntry(s.getName(), s.getTelNo()));		
	}

}
