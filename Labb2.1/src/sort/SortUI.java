package sort;

import java.text.NumberFormat;

import model.Employee;
public class SortUI {

	public void showSortMenu() {
		System.out.println("\n---------- SORT MENU ----------");
		System.out.println("\n1. Print employees sorted by names \n--- (Employee implements Comparable)");	
		System.out.println("\n2. Print employees sorted by names, descending order \n--- (Comparator object)");	
		System.out.println("\n3. Print employees sorted by phone number, descending order \n--- (Comparator, lambda)");
		System.out.println("\n4. Print annually company payroll \n--- (Streams)");
		System.out.println("\n5. Print highly payed probitinatry employees \n--- (Streams)");
		System.out.println("\n6. Print phonebook of all employees, alphabetic order \n--- (Streams)");
		System.out.println("\n0. Back to Main Menu");
	}

	public void printEmployee(Employee e) {
		System.out.println(e);		
	}

	public void printPayout(double payout) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		System.out.println("The aggregated salary payout for one year is: \n" +formatter.format(payout));
	}

	public void printPhoneBookEntry(String name, String telNo) {
		System.out.println(fixLengthString(name, 15) + " " +fixLengthString(telNo, 15));
	}
	

	private String fixLengthString(String start, int length) {
		if (start.length() >= length) {
			//klipp av stängen till <length> antal tecken
			return start.substring(0, length); 
		} 
		else {
			//fyll ut stängen med blanksteg till <length> antal tecken
			while (start.length() < length) {
				start += " ";
			}
			return start;
		}
	}
	
}
