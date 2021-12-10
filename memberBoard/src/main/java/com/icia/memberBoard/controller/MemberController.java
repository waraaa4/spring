package com.icia.memberBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.memberBoard.dto.MemberDTO;
import com.icia.memberBoard.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	// 회원가입 페이지 이동
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveForm() {
		return "member/save";
	}
	
	// 회원가입 후 인덱스
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute MemberDTO member) throws IllegalStateException, IOException {
		int result = ms.save(member);
		if(result > 0) {
			return "index";
		} else {
			return "member/save";
		}
	}
	
	// 회원가입시 아이디 중복체크
	@RequestMapping(value = "/idDuplicate", method = RequestMethod.POST)
	public @ResponseBody String idDuplicate(@RequestParam("m_id") String m_id) {
		String result = ms.idDuplicate(m_id);
		return result; // "ok" or "no"
	}
	
	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "member/login";
	}
	
	// 로그인할때 아이디, 비번이 일치하는지 확인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO member) {
		String resultPage = ms.login(member);
		return resultPage;
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 세션에 저장된 데이터를 지움.
		session.invalidate();
		return "index";
	}
	
	// 관리자가 전체회원 조회
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<MemberDTO> memberList = ms.findAll();
		model.addAttribute("memberList", memberList);
		return "member/adminPage";
	}
	
	// 관리자가 원하는 회원 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("m_number") long m_number) {
		ms.delete(m_number);
		return "redirect:/member/adminPage";
	}
	
	// 마이페이지 이동
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage(Model model) {
		List<MemberDTO> memberList = ms.findAll();
		model.addAttribute("memberList", memberList);
		return "member/myPage";
	}
	
	// 회원정보 수정하는 페이지 이동
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm(@RequestParam("m_number") long m_number, Model model) {
		MemberDTO member = ms.findById(m_number);
		model.addAttribute("member", member);
		return "member/update";
	}
	
	// 회원수정을 완료하고 그 회원을 myPage 페이지에 출력
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute MemberDTO member, Model model) {
		ms.update(member);
		return "redirect:/member/myPage";
	}
	
}
