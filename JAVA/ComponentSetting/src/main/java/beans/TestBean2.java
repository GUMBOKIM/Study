package beans;

import org.springframework.stereotype.Component;

@Component("t3")
public class TestBean2 {

		public TestBean2() {
			System.out.println("TESTBEAN2의 생성자");
		}
}
