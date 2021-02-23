package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import beans.DataBean1;
import beans.DataBean2;
import beans.TestBean1;
import beans.TestBean2;

@Configuration
public class BeanConfigClass {
	
	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}
	
	@Bean
	public DataBean1 data_bean1() {
		return new DataBean1();
	}
	
	@Bean
	public DataBean2 obj4() {
		return new DataBean2();
	}
	
	@Bean
	public DataBean2 obj5() {
		return new DataBean2();
	}
	
	@Bean
	TestBean2 java2() {
		return new TestBean2();
	}

}
