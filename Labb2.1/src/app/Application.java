package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ManagementController;
import controller.StatsController;
import model.EmployeeRegister;
import view.ManagementUI;
import view.StatsUI;

public class Application {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EmployeeRegister empRec = new EmployeeRegister();
		ManagementUI mUI = new ManagementUI();
		StatsUI statsUI = new StatsUI();
		ManagementController managementController = new ManagementController(empRec, mUI);
		StatsController statsController = new StatsController(empRec, statsUI);
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
			case 1 :
				managementController.employeeManagement();
				break;
			case 2: 
				statsController.runStatistics();
				break;
			case 3:
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
