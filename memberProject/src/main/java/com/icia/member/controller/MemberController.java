package com.icia.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

// 컨트롤러 사용하겠다고 선언
@Controller
public class MemberController {
	
	// new 대신 스프링이 객체를 알아서 만들어 줌. 
	@Autowired
	private MemberService ms;
	
	// 회원가입 페이지 이동
	@RequestMapping(value = "/saveform", method = RequestMethod.GET)
	public String savaForm() {
		return "save";
	}
	
	// 회원가입 후 인덱스로 이동
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String sava(@ModelAttribute MemberDTO member) {
		System.out.println("MemberController.save(): " + member);
		int result = ms.save(member);
		if(result > 0) {
			return "index";
		} else {
			return "save";
		}
	}
	
	// 로그인 페이지 이동
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	// 로그인 아이디,비번이 맞는지 아닌지 확인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO member) {
		String resultPage = ms.login(member);
		return resultPage;
	}
	
	// 로그아웃 처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 세션에 저장된 데이터를 지움.
		session.invalidate();
		return "index";
	}
	
	// 전체회원 조회
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<MemberDTO> memberList = ms.findAll();
		model.addAttribute("memberList", memberList);
		return "findAll";
	}
	
	// 원하는 회원조회
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String findById(@RequestParam("m_number") long m_number, Model model) {
		MemberDTO member = ms.findById(m_number);
		model.addAttribute("member", member);
		return "detail";
	}
	
	
	

	
	
}