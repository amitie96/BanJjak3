package com.mysite.banzzak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BanzzakController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Banzzak";
	}
}
