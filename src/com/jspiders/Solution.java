package com.jspiders;

import java.util.Scanner;
import com.customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementImpl();

		System.out.println("WELCOME TO STUDENT DATABASE PROJECT");
		System.out.println("==========================================================");

		while(true) {
			System.out.println("1:Add Student\n2:Display Student\n3:Display All Student");
			System.out.println("4:Remove Student\n5:Remove All Student\n6:Update Student\n7:Count of Students\n8:Sort Students\n9:Exit");
			System.out.println("Enter the Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				sms.addStudent();
				break;

			case 2:
				sms.displayStudent();
				break;
				
			case 3:
				sms.displayAllstudent();
				break;

			case 4:
				sms.removeStudent();
				break;

			case 5:
				sms.removeAllStudent();
				break;

			case 6:
				sms.updateStudent();
				break;

			case 7:
				sms.countStudents();
				break;

			case 8:
				sms.sortStudents();
				break;

			case 9:
				System.out.println("Thank you");
				System.exit(0);

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					e.getMessage();

				}
			}
			System.out.println("===================================");
		}
	}
}
