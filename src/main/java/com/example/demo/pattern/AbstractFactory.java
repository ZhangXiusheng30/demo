package com.example.demo.pattern;

import com.example.demo.dao.Animal;
import com.example.demo.dao.Person;
import com.example.demo.dao.impl.Cat;
import com.example.demo.dao.impl.Dog;
import com.example.demo.dao.impl.Student;
import com.example.demo.dao.impl.Teacher;

public class AbstractFactory extends AbstractFactoryPattern{

	@Override
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

	@Override
	public Animal getAnimal(String type) {
	if (!"".equals(type) && type != null) {
			
			if (type.equalsIgnoreCase("Cat")) {
				return new Cat();
			}
			if (type.equalsIgnoreCase("Dog")) {
				return new Dog();
			}
		}
		return null;
	}

}
