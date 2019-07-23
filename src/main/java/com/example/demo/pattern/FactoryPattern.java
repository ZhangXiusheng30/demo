package com.example.demo.pattern;

import com.example.demo.dao.Person;
import com.example.demo.dao.impl.Student;
import com.example.demo.dao.impl.Teacher;

public class FactoryPattern {

	public Person getPerson(String type) {
		
		if (!"".equals(type) && type != null) {
			
			if (type.equalsIgnoreCase("Student")) {
				return new Student();
			}
			if (type.equalsIgnoreCase("Teacher")) {
				return new Teacher();
			}
		}
		return null;
	}

}
