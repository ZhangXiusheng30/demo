package com.example.demo.pattern;

import com.example.demo.dao.Animal;
import com.example.demo.dao.Person;

public abstract class AbstractFactoryPattern {
	public abstract Person getPerson(String type);
	public abstract Animal getAnimal(String type);
}
