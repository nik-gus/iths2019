package model;

import java.time.LocalDate;

import utilities.EmploymentStatus;


public abstract class Employee {
	
	protected static int idCounter = 1;
	protected final int EMPID; //unikt id nr. final va??
	protected String name;
	protected String telNo;
	protected double salary;
	protected LocalDate employmentDate;
	protected EmploymentStatus status;
	
	public Employee(String name, String telNo, double salary) {
		EMPID = createID();
		this.name = name;
		this.telNo = telNo;
		this.salary = salary;
		employmentDate = LocalDate.now();	
		status = EmploymentStatus.PROBATIONARY;
	}
	
	public static synchronized int createID() {
	    return idCounter++;
	}    
	
	 /* Must be overridden!*/
	public abstract void permanentEmploymentRaise();
	
	public String toString() {
		StringBuilder sb = new StringBuilder("\nEMPLOYEE #");
		sb.append(EMPID);
		sb.append("\nName:  ");
		sb.append(name);
		sb.append("\nPhone number:  ");
		sb.append(telNo);
		sb.append("\nSalary:  ");
		sb.append(String.format("%.2f", salary));
		sb.append("\nEployment status:  ");
		sb.append(status);
		return sb.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}
	
	public void setEmploymentDate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public int getEMPID() {
		return EMPID;
	}

	public EmploymentStatus getStatus() {
		return status;
	}

	public void setStatus(EmploymentStatus status) {
		this.status = status;
	}
	
} //end class
