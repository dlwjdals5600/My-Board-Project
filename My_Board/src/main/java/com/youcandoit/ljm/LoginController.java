package com.youcandoit.ljm;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception {
		// 1. id와 pwd를 확인
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "uft-8");
			
			// 2-1. 일치하지 않으면, loginForm으로 이동
			return "redirect:/login/login?msg="+msg;
		}
		// 2-2. id와 pwd가 일치하면,
		// 아이디 기억 체크 유무 확인
		
		if(rememberId) {
//			1. 쿠키를 생성
			System.out.println(rememberId);
			Cookie cookie = new Cookie("id", "asdf");
			response.addCookie(cookie);
//			2. 응답에 저장
			
		} else {
			Cookie cookie = new Cookie("id", "asdf");
			cookie.setMaxAge(0);	// 쿠키 삭제
			response.addCookie(cookie);
			
		}

//				3. 홈으로 이동
		return "redirect:/";
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd);
	}
	
}
