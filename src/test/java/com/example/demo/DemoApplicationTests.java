package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.Person;
import com.example.demo.pattern.FactoryPattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		FactoryPattern factoryPattern = new FactoryPattern();
		Person student = factoryPattern.getPerson("student");
		student.sayHello();
		Person teacher = factoryPattern.getPerson("teacher");
		teacher.sayHello();
	}

}
