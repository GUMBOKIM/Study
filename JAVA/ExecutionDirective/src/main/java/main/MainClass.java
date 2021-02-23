package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.TestBean1;
import beans.TestBean2;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");

		TestBean1 xml1 = ctx.getBean("xml1", TestBean1.class);
		TestBean2 xml2 = ctx.getBean("xml2", TestBean2.class);
		beans2.TestBean1 xml3 = ctx.getBean("xml2", beans2.TestBean1.class);
		xml1.method1();
		
		
		System.out.println("------------------------------");

		xml1.method1(100);

		System.out.println("------------------------------");

		xml1.method1("±â¸ð¶ì");

		System.out.println("------------------------------");

		xml1.method1(100, 200);

		System.out.println("------------------------------");

		xml1.method1(100, "±â¸ð¶ì");

		System.out.println("------------------------------");

		xml1.method2();

		System.out.println("------------------------------");

		xml2.method1();

		ctx.close();
	}

}
