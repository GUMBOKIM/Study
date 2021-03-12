package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import beans.DataBean;
import database.MapperInterface;
import service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test1")
	public String input_data(Model model) {
		
		String str = testService.testMethod();
		
		model.addAttribute("str",str);
		
		return "test1";
	}
	

}
