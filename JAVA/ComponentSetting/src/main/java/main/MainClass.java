package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.TestBean1;
import beans.TestBean2;
import beans.TestBean3;
import beans.TestBean4;
import beans.TestBean5;
import config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 t1 = ctx.getBean(TestBean1.class);
		System.out.printf("t1 : %s\n",t1);
		
		TestBean2 t2 = ctx.getBean("t3",TestBean2.class);
		System.out.printf("t2 : %s\n",t2);
		
		TestBean2 t5 = ctx.getBean("t5",TestBean2.class);
		System.out.printf("t5 : %s\n",t5);
		
		TestBean3 t7 = ctx.getBean(TestBean3.class);
		System.out.printf("t7 : %s\n",t7);
		
		TestBean3 t8 = ctx.getBean(TestBean3.class);
		System.out.printf("t7 : %s\n",t8);
		
		TestBean4 t9 = ctx.getBean(TestBean4.class);
		System.out.printf("t9 : %s\n", t9);
		
		TestBean4 t10 = ctx.getBean(TestBean4.class);
		System.out.printf("t10 : %s\n", t10);
		

		TestBean5 t11 = ctx.getBean(TestBean5.class);
		System.out.printf("t11 : %s\n", t11);
		
		
		
		ctx.close();
	}

}
