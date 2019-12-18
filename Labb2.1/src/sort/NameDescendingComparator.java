package sort;

import java.util.Comparator;

import model.Employee;

public class NameDescendingComparator implements Comparator<Employee> {

	@Override //descending order
	public int compare(Employee o1, Employee o2) {
		return -(o1.getName().compareTo(o2.getName()));
	}

}
