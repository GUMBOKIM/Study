package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean2 {
	
	public TestBean2() {
		System.out.println("TestBean2의 생성자");
	}
	
	@PostConstruct
	public void init2() {
		System.out.println("TestBean2의 init");
	}
	
	@PreDestroy
	public void destroy2() {
		System.out.println("TestBean2의 destroy");
	}
	
	
}
