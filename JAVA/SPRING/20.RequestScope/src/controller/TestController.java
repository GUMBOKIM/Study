package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import beans.DataBean1;

@Controller
public class TestController {

	// HttpServletRequest
	// redirect는 호출된 메소드 내에서 객체가 생성되고 메소드 종료시 객체가 소멸된다.
	// forward는 호출된 메소느 내에서 객체가 생성되고 브라우저로 보내기가 완료된 후 소멸된다.

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		request.setAttribute("data1", "문자열1");
		return "forward:/result1";
	}

	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		String data1 = (String) request.getAttribute("data1");
		System.out.println("data1 : " + data1);
		return "result1";
	}

	// Model
	// Model 객체는 호출된 메소드 내에서 객체가 생성되고 전달되지 안된다.(Request영역에 저장됨

	@GetMapping("/test2")
	public String test2(Model model) {

		model.addAttribute("data2", "문자열");

		return "forward:/result2";
	}

	@GetMapping("/result2")
//	public String result2(Model model) {
	public String result2(HttpServletRequest model) {
		String data2 = (String) model.getAttribute("data2");
		System.out.println("data2 : " + data2);
		return "result2";
	}
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {

		mv.addObject("data3", "문자열3");
		mv.setViewName("forward:/result3");
		
		return mv;
	}

	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		String data3 = (String)request.getAttribute("data3");
		System.out.println("data3 : " + data3);
		return "result3";
	}
	
	@GetMapping("/test4")
	public String test4(Model model) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");

		model.addAttribute("bean1",bean1);
		return "forward:/result4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpServletRequest request) {
		
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		System.out.println("data1 : " + bean1.getData1());
		System.out.println("data2 : " + bean1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/test5")
	public String test5(@ModelAttribute("bean1") DataBean1 bean1) {
		bean1.setData1("문자열6");
		bean1.setData2("문자열7");
		
		return "forward:/result5";
	}
	
	@GetMaping("/result5")
	public String result5(@ModelAttribute("bean1") DataBean1 bean1) {

		System.out.println("bean1.data1 : " + bean1.getData1());
		System.out.println("bean1.data2 : " + bean1.getData2());
		
		return "result5";
	}
}