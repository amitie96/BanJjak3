package com.mysite.banzzak.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/banzzak")
	@ResponseBody
	public String index() {
		return "안녕하세요 너무 어렵네요~~";
	}
	
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
