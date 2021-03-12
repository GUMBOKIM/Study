package controller;

import javax.annotation.Resource;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import beans.DataBean1;
import beans.DataBean2;

@Controller
public class TestController {
	
	@Autowired
	DataBean1 sessionBean1;
	
	@Resource(name="sessionBean2")
	@Lazy
	DataBean2 sessionBean2;
	
	@GetMapping("/test1")
	public String test1() {
		
		sessionBean1.setData1("data1");
		sessionBean1.setData2("data2");
		
		sessionBean2.setData3("data3");
		sessionBean2.setData4("data4");
		
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1() {
		
		System.out.println("sessionBean1.data1 : " + sessionBean1.getData1());
		System.out.println("sessionBean1.data1 : " + sessionBean1.getData2());
		System.out.println("sessionBean2.data3 : " + sessionBean2.getData3());
		System.out.println("sessionBean2.data4 : " + sessionBean2.getData4());
	
		
		return "result1";
	}
}
