package com.cjh.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	// 기본주소요청을 처리하는 메서드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	// loginpage 주소 요청을 처리하는 메서드
	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String liginpage() {
		return "login";
	}
	
	// login 주소 요청을 처리하는 메서드
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam("id") String id, @RequestParam("password") String password) {
		System.out.println("id:"+id+" password:"+password);
		
		// id를 model에 담아서 welcome.jsp로 가져가기
		model.addAttribute("idValue",id);
		
		// password를 pwValue에 담고 welcome.jsp에서 출력
		model.addAttribute("pwValue",password);
		
		// val 변수를 hello에 담고 welcome.jsp에서 출력
		String val = "이제 곧 끝나요";
		model.addAttribute("hello",val);
		
		return "welcome";
	}
	
}
