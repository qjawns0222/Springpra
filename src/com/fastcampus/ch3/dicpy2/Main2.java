package com.fastcampus.ch3.dicpy2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Engine {
}

class Car {
}

class sportsCar extends Car {
}

class Truck extends Car {
}

class AppContext {
	Map<Object, Object> map;

		AppContext() throws Exception {
		Properties p = new Properties();
		p.load(new FileReader("config.txt"));
		map=new HashMap(p);
		for(Object key:map.keySet()) {
			Class clazz = Class.forName((String)map.get(key));
			
			map.put(key,clazz.getDeclaredConstructor().newInstance());
		}
		
	}

	Object getBean(String key) {
	
		return map.get(key);
	}
	Object getBean(Class clazz) {
		for(Object val:map.values()) {
			if(clazz.isInstance(val)) {
				return val;
			}
		}
		return null;
		
	}
}

public class Main2 {
	public static void main(String[] args) throws Exception {
		AppContext ac = new AppContext();
		Car car = (Car) ac.getBean("car");
		Car car2 = (Car) ac.getBean(car.getClass());
		Engine engine = (Engine) ac.getBean("engine");
		Engine engine2= (Engine) ac.getBean(engine.getClass());
		System.out.println("car2=" + car2);
		System.out.println("engine2=" + engine2);
	}

	private static Car getCar() throws Exception {

		Properties p = new Properties();
		p.load(new FileReader("config.txt"));
		Class clazz = Class.forName(p.getProperty("car"));

		return (Car) clazz.newInstance();
	}

	private static Object getObject(String key) throws Exception {

		Properties p = new Properties();
		p.load(new FileReader("config.txt"));
		Class clazz = Class.forName(p.getProperty(key));

		return clazz.newInstance();
	}

}
