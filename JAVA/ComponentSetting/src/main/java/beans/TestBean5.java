package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TestBean5 {
	
	public TestBean5() {
		System.out.println("TestBean5's Generator");
	}
	
	@PostConstruct
	public void init5() {
		System.out.println("init method was called");
	}
	
	@PreDestroy
	public void destroy5() {
		System.out.println("destroy method was called");
	}
}
