package ocs.db;

import java.util.ArrayList;

import ocs.pojos.Student;

public class OCSDb {
	String[] nameList = {"John", "Rakesh", "Ramesh", "Abhishek", "Ajay", "Danial", "Sachin", "Yuvi", "Kohli", "Dhoni", "Jadeja", "Bhuvneshwar"
						, "Monalisa"};
	String[] branches = {"CSE", "ECE", "EEE", "MEC", "CIV", "MATH"};
	long[] rollList = {2022001, 2022002, 2022003, 2022004, 2022005, 2022006, 2022007, 2022008, 2022009, 2022010};
	int nameSize = nameList.length, branchSize = branches.length, rollSize = rollList.length;
	public Student student = new Student(nameList[(int)(Math.random()*nameSize)], branches[(int)(Math.random()*branchSize)], rollList[(int)(Math.random()*rollSize)]);
	public ArrayList<Integer> getMarks() {
		ArrayList<Integer> marks = new ArrayList<>();
		for(int i=0; i<5; i++) {
			marks.add((int)(Math.random()*50+10));
		}
		return marks;
	}
	public String getName() {
		return nameList[(int)(Math.random()*nameSize)];
	}
	
 }
