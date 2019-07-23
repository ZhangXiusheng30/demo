package com.example.demo.pattern;

public class SingletonPattern_3 {
	private static SingletonPattern_3 instance = new SingletonPattern_3();

	private SingletonPattern_3() {
	}

	private static SingletonPattern_3 getInstance() {
		return instance;
	}

}
