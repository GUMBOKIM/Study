package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import beans.DataBean1;

@Controller
public class TestController {

	@GetMapping("/test1")
	//public String test1(HttpServletRequest request) {
	public String test1(HttpSession session) {
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열1");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	//public String test1(HttpServletRequest request) {
	public String test2(HttpSession session) {
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열2");
		
		return "redirect:/result1";
	}
	
	@GetMapping("/test3")
	//public String test1(HttpServletRequest request) {
	public String test3(HttpSession session) {
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열3");
		
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(HttpSession session) {
		
		//HttpSession session = request.getSession();
		String data1 = (String)session.getAttribute("data1");
		
				
		System.out.println("data1 : " + data1);
		
		return "result1";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		session.setAttribute("bean1", bean1);
		
		return "test4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpSession session) {
		DataBean1 bean1 = (DataBean1)session.getAttribute("bean1");
		
		System.out.println("bean1.data1 : " + bean1.getData1());
		System.out.println("bean1.data2 : " + bean1.getData2());
		
		return "result4";
	}
}
