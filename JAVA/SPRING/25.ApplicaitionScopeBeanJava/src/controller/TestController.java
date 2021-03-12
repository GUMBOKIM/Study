package controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import beans.DataBean1;
import beans.DataBean2;

@Controller
public class TestController {
		
	@Autowired
	DataBean1 applicationBean1;
	
	@Resource(name = "applicationBean2")
	DataBean2 applicationBean2;
	
	@GetMapping("/test1")
	public String test1() {
		
		applicationBean1.setData1("data1");
		applicationBean1.setData2("data2");
		
		applicationBean2.setData3("data3");
		applicationBean2.setData4("data4");
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		
		System.out.println("applicationBean1.data1 : "+ applicationBean1.getData1());
		System.out.println("applicationBean1.data2 : "+ applicationBean1.getData2());
		
		System.out.println("applicationBean2.data3 : "+ applicationBean2.getData3());
		System.out.println("applicationBean2.data4 : "+ applicationBean2.getData4());
		
		model.addAttribute("applicationBean1",applicationBean1);
		model.addAttribute("applicationBean2",applicationBean2);
		
		
		return "result1";
	}
}
