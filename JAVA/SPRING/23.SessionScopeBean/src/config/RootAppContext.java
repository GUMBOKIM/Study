package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import beans.DataBean1;
import beans.DataBean2;
import beans.DataBean3;
import beans.DataBean4;

//������Ʈ �۾��� ����� bean�� �����ϴ� Ŭ����
@Configuration
public class RootAppContext {

	@Bean
	@SessionScope
	public DataBean1 dataBean1() {
		return new DataBean1();
	}
	
	@Bean("sessionBean2")
	@SessionScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
	
	@Bean
	@SessionScope
	public DataBean3 dataBean3() {
		return new DataBean3();
	}
	
	@Bean("sessionBean4")
	@SessionScope
	public DataBean4 dataBean4() {
		return new DataBean4();
	}
	
	
	
}
