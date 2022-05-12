package ocs.pojos;

public class Student {
	String name;
	String branch = "CSE";
	long rollNum;
	
	public Student() {}

	public Student(String name, long rollNum) {
		super();
		this.name = name;
		this.rollNum = rollNum;
	}

	public Student(String name, String branch, long rollNum) {
		super();
		this.name = name;
		this.branch = branch;
		this.rollNum = rollNum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Name : " + name + "\tRoll no. : " + rollNum + "\tBranch : " + branch;
	}
}
