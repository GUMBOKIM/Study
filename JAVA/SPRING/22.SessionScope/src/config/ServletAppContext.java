package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring MVC�� ���õ� ������ �ϴ� Ŭ����
@Configuration
// Controller ������̼��� ���õǾ� �ִ� Ŭ������ Controller�� ����Ѵ�.
@EnableWebMvc
//��ĵ�� ��Ű���� �����Ѵ�.
@ComponentScan("controller")
public class ServletAppContext implements WebMvcConfigurer {

	// Controller�� �޼��尡 ��ȯ�ϴ� jsp�� �̸� ��Ƣ�� ��ο� Ȯ���ڸ� �ҷ��ֵ��� �����Ѵ�.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
		
	//���� ������ ��θ� �����Ѵ�.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
		
	}
	
	
	
}
