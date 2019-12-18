package model;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

public class EmployeeRegister {
	
	private List<Employee> empList;
	
	public EmployeeRegister() {
		empList = new ArrayList<Employee>();
	}

	public List<Employee> getEmpList() {
		return empList;
	}
	
} //end class
