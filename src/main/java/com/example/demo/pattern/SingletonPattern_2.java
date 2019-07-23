package com.example.demo.pattern;
/**
 * 懒汉式，线程安全，效率低
 * */
public class SingletonPattern_2 {
	private static SingletonPattern_2 instance;
	private SingletonPattern_2() {}
	private static synchronized SingletonPattern_2 getInstance() {
		if(instance==null) {
			instance = new SingletonPattern_2();
		} 
		return instance;
	}
}
