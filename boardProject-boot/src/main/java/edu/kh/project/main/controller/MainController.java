package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 요청/응답 제어 역할 명시 + Bean 등록
public class MainController {
	
	@RequestMapping("/") // "/" 요청 매핑
	public String mainPage() {
		
		// forward 하겠다라는 의미
		return "common/main";
	}
	
}
