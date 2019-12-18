package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import management.ManagementController;
import management.ManagementUI;
import model.EmployeeRegister;
import sort.SortController;
import sort.SortUI;
import stats.StatsController;
import stats.StatsUI;

public class Application {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EmployeeRegister empReg = new EmployeeRegister();
		ManagementUI mUI = new ManagementUI();
		StatsUI statsUI = new StatsUI();
		SortUI sortUI = new SortUI();
		ManagementController managementController = new ManagementController(empReg, mUI);
		StatsController statsController = new StatsController(empReg, statsUI);
		SortController sortController = new SortController(empReg, sortUI);

		managementController.loadDemo(); //FOR DEMO ONLY!
		
		boolean run = true;
		int choice;
		do {
			mUI.showMainMenu();
			try {
				choice = sc.nextInt(); 
			} catch (InputMismatchException e) {
				choice = 9;
			}
			sc.nextLine();
			switch (choice) {
			case 0:
				System.out.println("Application terminated.");
				run = false;
				break;
			case 1 :
				managementController.employeeManagement();
				break;
			case 2: 
				statsController.runStatistics();
				break;
			case 3: 
				sortController.runSort();
				break;
			case 4:
				System.out.println("Application terminated");
				run = false;
				break;
			default: 
				System.out.println("Wrong input");
				break;
			}
		} while (run);
	}

} //end class
