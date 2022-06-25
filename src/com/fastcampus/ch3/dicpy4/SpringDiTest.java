package com.fastcampus.ch3.dicpy4;

import java.util.Arrays;
@Component("engine")
class Engine{}
@Component("engine")
class superEngine extends Engine{}
@Component("engine")
class turboEngine extends Engine{}
@Component
class Door{}
@Component
class Car{
	@Value("red") String color;
	@Value("100") int oil;
	@AutoWired Engine engine;
	@AutoWired Door[] doors;
	
	public Car(String color, int oil, Engine engine, Door[] doors) {
		super();
		this.color = color;
		this.oil = oil;
		this.engine = engine;
		this.doors = doors;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getOil() {
		return oil;
	}
	public void setOil(int oil) {
		this.oil = oil;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Door[] getDoors() {
		return doors;
	}
	public void setDoors(Door[] doors) {
		this.doors = doors;
	}
	@Override
	public String toString() {
		return "Car [color=" + color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
	
}
public class SpringDiTest {
	public static void main(String[] args) {
		ApplicationContext ac= new GenericXmlApplicationContext("config.xml");
		Car car=(Car)ac.getBean("car");
		Car car2=ac.getBean("car",Car.class);
		Engine engine=(Engine)ac.getBean("engine");
		Door door=(Door)ac.getBean("door");
		
		/*
		 * car.setColor("red"); car.setOil(100); car.setEngine(engine); car.setDoors(new
		 * Door[] {ac.getBean("door",Door.class),ac.getBean("door",Door.class)});
		 */
		System.out.println("car="+car);
	}
	
}
