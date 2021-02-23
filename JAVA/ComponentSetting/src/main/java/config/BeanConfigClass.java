package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.TestBean2;

@Configuration
@ComponentScan(basePackages = "beans")
public class BeanConfigClass {

	@Bean
	public TestBean2 t5() {
		return new TestBean2();
	}
}
