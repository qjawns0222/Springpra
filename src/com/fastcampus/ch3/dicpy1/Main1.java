package com.fastcampus.ch3.dicpy1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
class Engine{}
class Car{}
class sportsCar extends Car{}
class Truck extends Car{}
public class Main1 {
	public static void main(String[] args) throws Exception {
		Car car=(Car)getObject("car");
		Engine engine=(Engine)getObject("engine");
		System.out.println("car="+car);
		System.out.println("engine="+engine);
	}

	private static Car getCar() throws Exception {
		
		Properties p= new Properties();
		p.load(new FileReader("config.txt"));
		Class clazz=Class.forName(p.getProperty("car"));
		
		return (Car)clazz.newInstance();
	}
	
	private static Object getObject(String key) throws Exception {
		
		Properties p= new Properties();
		p.load(new FileReader("config.txt"));
		Class clazz=Class.forName(p.getProperty(key));
		
		return clazz.newInstance();
	}


}
