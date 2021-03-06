package com.cjh.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	// 리턴타입: String
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// 기본주소(/) 요청에 대해 home.jsp를 출력해줌.
		// 컨트롤러 메서드에서 String 리턴은 해당 String값.jsp 를 출력하도록 처리됨
		// viewResolver가 해줌.
		return "home";
	}
	
	// hello 주소를 받아줄 메서드 선언
	@RequestMapping(value="/hello")
	public String hello() {
		// hi.jsp 출력
		return "hi";
	}
	
	// intro 주소를 받아줄 메서드 선언
	@RequestMapping(value="/intro")
	public String intro() {
		return "intro";
	}
	
	// input 주소를 받아줄 메서드 선언
	@RequestMapping(value = "/input")
	public String input() {
		return "input";
	}
	
	// 화면에서 전달한 파라미터 받기
	@RequestMapping(value = "/inputparam", method = RequestMethod.POST)
	public String inputparam(@RequestParam("param1") String param1,
								@RequestParam("param2") String param2) {
		System.out.println("inputParam 메서드");
		System.out.println("param1:"+param1+" param2:"+param2);
		return "home";
	}
	
	
}
