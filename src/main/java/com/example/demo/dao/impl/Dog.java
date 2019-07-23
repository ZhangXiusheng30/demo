package com.example.demo.dao.impl;

import com.example.demo.dao.Animal;

public class Dog implements Animal{

	@Override
	public void eat() {
		System.out.println("Dog eat 骨头！");		
	}

}
