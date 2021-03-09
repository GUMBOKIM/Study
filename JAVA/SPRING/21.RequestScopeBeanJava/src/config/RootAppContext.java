package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import beans.DataBean1;
import beans.DataBean2;

//������Ʈ �۾��� ����� bean�� �����ϴ� Ŭ����
@Configuration
public class RootAppContext {
	@Bean
	@RequestScope
	public DataBean1 databean1() {
		return new DataBean1();
	}
	
	@Bean("requestBean2")
	@RequestScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
}
