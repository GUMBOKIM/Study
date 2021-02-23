package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import beans.*;

@Configuration
@ComponentScan(basePackages = "beans")
public class BeanConfigClass {
	
	@Bean
	public DataBean3 obj4() {
		return new DataBean3();
	}
	
	@Bean
	public DataBean3 obj5() {
		return new DataBean3();
	}
	
	@Bean
	public TestBean3 java3() {
		TestBean3 t3 = new TestBean3(200, "¹®ÀÚ¿­", new DataBean4(), new DataBean5());
		return t3;
	}

}
