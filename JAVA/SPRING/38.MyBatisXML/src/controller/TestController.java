package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.mybatis.spring.SqlSessionTemplate;

import beans.DataBean;

@Controller
public class TestController {
	
	@Autowired
	SqlSessionTemplate SqlSessionTemplate;
	
	@GetMapping("/input_data")
	public String input_data() {
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_data(DataBean dataBean) {
		
		SqlSessionTemplate.insert("test_db.insert_data", dataBean);
		
		return "input_pro";
	}
}
