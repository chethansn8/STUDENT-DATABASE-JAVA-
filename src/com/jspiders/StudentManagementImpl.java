package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.sortingLogic.*;

import com.customexception.InvalidChoiceException;
import com.customexception.StudentNotFoundException;

class StudentManagementImpl implements StudentManagementSystem {
	Map <String,Student>db = new LinkedHashMap();
	Scanner sc=new Scanner(System.in);

	public void addStudent() {
		System.out.println("Enter Student name");
		String name=sc.next();
		System.out.println("Enter Student age");
		int age=sc.nextInt();
		System.out.println("Enter Student marks");
		int marks=sc.nextInt();

		Student s=new Student(name, age, marks);

		db.put(s.getId(),s);
		System.out.println("Student details inserted successfully");
		System.out.println("Student id is:"+s.getId());
	}

	public void displayStudent() {
		System.out.println("Enter the id of Student to retrieve data");
		String id=sc.next();
		id = id.toUpperCase();

		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("Id: "+std.getId());
			System.out.println("Name: "+std.getName());
			System.out.println("Age: "+std.getAge());
			System.out.println("Marks: "+std.getMarks());
		}
		else {
			try {
				throw new StudentNotFoundException("No Student records found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void displayAllstudent() {
		Set<String>keys=db.keySet();
		System.out.println("Student Records are as follows");
		System.out.println("--------------------------------");
		if(db.size()!=0) {
			for(String key:keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				throw new StudentNotFoundException("No Student records to display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void removeStudent() {
		System.out.println("Enter Student id to delete details");
		String id=sc.next();
		id = id.toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student details Deleted Successfully");
		}
		else {
			try {
				throw new StudentNotFoundException("No student records found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}


	public void removeAllStudent() {
		db.clear();
		System.out.println("Student records deleted Successfully");
	}

	public void updateStudent() {
		System.out.println("Enter the id of Student");
		String id=sc.next();
		if(db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Marks\n:Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter new name");
				String name=sc.next();
				std.setName(name);
				System.out.println("Updated Successfully");
				break;

			case 2:
				System.out.println("Enter new age");
				int age=sc.nextInt();
				std.setAge(age);
				System.out.println("Updated Successfully");
				break;

			case 3:
				System.out.println("Enter new Marks");
				int marks=sc.nextInt();
				std.setMarks(marks);
				System.out.println("Updated Successfully");
				break;

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					e.getMessage();

				} 
			}
		}
		else {
			try {
				throw new StudentNotFoundException("No Student records to display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			} 
		}
	}

	public void countStudents() {
		System.out.println("Size of Student Records is "+db.size());
	}

	public void sortStudents() {
		Set<String>keys=db.keySet();
		List<Student>l=new ArrayList<Student>();
		for(String s:keys) {
			l.add(db.get(s));
			}
		System.out.println("1:Sort BY id\n2:Sort BY Name\n3:Sort BY Age\n4:Sort BY Marks");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			Collections.sort(l,new SortStudentByID());
			display(l);
			break;
			
		case 2:
			Collections.sort(l,new SortStudentByName());
			display(l);
			break;
			
		case 3:
			Collections.sort(l,new SortStudentByAge());
			display(l);
			break;
			
		case 4:
			Collections.sort(l,new SortStudentByMarks());
			display(l);
			break;
			
		default:
			try {
				throw new InvalidChoiceException("Invalid Choice");
			}
			catch(Exception e) {
				e.getMessage();

			} 
		}
	}
		private static void display(List<Student> l) {
			for(Student s:l) {
				System.out.println(s);
			}
	}
}

