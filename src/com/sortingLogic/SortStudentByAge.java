package com.sortingLogic;

import java.util.Comparator;

import com.jspiders.Student;

public class SortStudentByAge implements Comparator<Student>{
	public int compare(Student s1,Student s2) {
		return s1.getAge() - s2.getAge();
	}
}
