package controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import beans.DataBean;
import beans.DataBean2;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3");
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		for(String str : data3) {
			System.out.println("data3 : " + str);
		}
		return "result";
	}
	
	@GetMapping("/test2")
	//  public String test2(@ModelAttribute DataBean bean1,@ModelAttribute DataBean2 bean2) {
	// ModelAttribute는 생략해도 가능
	public String test2(DataBean bean1, DataBean2 bean2) {
		
		System.out.println("data1 : " + bean1.getData1());
		System.out.println("data2 : " + bean1.getData2());
		
		for(int number1 : bean1.getData3()) {
			System.out.printf("data3 : %d\n", number1);
		}
		
		System.out.println("bean2.data1 : " + bean2.getData1());
		System.out.println("bean2.data2 : " + bean2.getData2());
				
		
		return "result";
		
	}
}
