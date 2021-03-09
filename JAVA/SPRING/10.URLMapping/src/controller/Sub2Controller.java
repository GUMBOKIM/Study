package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sub2")
public class Sub2Controller {
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String test4() {
		return "/sub2/test4";
		
	}

	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String test5() {
		return "/sub2/test5";
	}

}
