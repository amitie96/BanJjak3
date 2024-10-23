package com.mysite.banzzak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/user")
public class BanzzakController {

	@GetMapping("/main")
	public String main() {

		return "main";
	}

}
