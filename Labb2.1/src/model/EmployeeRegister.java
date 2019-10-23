package model;

import java.util.HashMap;

public class EmployeeRegister {
	
	private HashMap<Integer, Employee> empMap;
	
	public EmployeeRegister() {
		empMap = new HashMap<Integer, Employee>();
	}

	public HashMap<Integer, Employee> getEmpMap() {
		return empMap;
	}
	
} //end class
