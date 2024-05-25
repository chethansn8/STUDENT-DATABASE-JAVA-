package com.sortingLogic;

import java.util.Comparator;


import com.jspiders.Student;

public class SortStudentByName implements Comparator<Student> {
	public int compare(Student s1,Student s2) {
		return s1.getName().compareTo(s2.getName());
	}

}
