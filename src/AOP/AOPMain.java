package AOP;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AOPMain {
	public static void main(String[] args) throws ClassNotFoundException {
		MyAdvice myAdvice=new MyAdvice();
		
		Class myClass=Class.forName("AOP.MyClass");
		Object obj=MyClass.instance;
		for(Method m:myClass.getDeclaredMethods()) {
			myAdvice.invoke(m,obj);
		}
		
	}

}
class MyAdvice{
	void invoke(Method m,Object obj,Object...args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("[before]{");
		m.invoke(obj, args);
		System.out.println("}[after]");
		
	}
}
class MyClass{
	void aaa(){
		System.out.println("aaa() is called");
	}
	void bbb(){
		System.out.println("bbb() is called");
	}
	void ccc(){
		System.out.println("ccc() is called");
	}
}
