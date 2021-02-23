package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.*;

@Configuration
// ������ ��Ű���� Bean Ŭ�������� ������̼��� �м��Ͽ� Bean�� ����϶�� �����Ѵ�.
@ComponentScan(basePackages = "beans2")
@ComponentScan(basePackages = "beans3")
public class BeanConfigClass {
	
	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}
	
	@Bean
	public TestBean2 java2() {
		return new TestBean2();
	}
	
	@Bean
	public TestBean2 java3() {
		return new TestBean2();
	}
	
	
}
