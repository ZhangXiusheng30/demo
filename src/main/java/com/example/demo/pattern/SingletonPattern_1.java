package com.example.demo.pattern;
/**
 * 懒汉式，线程不安全，不适用多线程
 * */
public class SingletonPattern_1 {
	private static SingletonPattern_1 instance;

	private SingletonPattern_1() {
	};

	private static SingletonPattern_1 getInstance() {
		if (instance == null) {
			instance = new SingletonPattern_1();
		}
		return instance;
	}
}
