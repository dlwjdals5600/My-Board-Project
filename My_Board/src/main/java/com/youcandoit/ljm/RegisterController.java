package com.youcandoit.ljm;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
//	@GetMapping("/register/add")
//	public String signUp() {
//		return "signUpForm";
//	}
	
	@PostMapping("/save")
	public String save(User user, Model m) throws Exception{
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.","utf-8");
			
			m.addAttribute("msg",msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting)
		}
		return "registerInfo";
	}

private boolean isValid(User user) {
	return true;
}
}
