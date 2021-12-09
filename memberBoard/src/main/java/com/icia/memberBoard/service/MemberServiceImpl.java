package com.icia.memberBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icia.memberBoard.dto.MemberDTO;
import com.icia.memberBoard.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository mr;
	
	@Autowired
	private HttpSession session;
	
	// 회원가입 & 파일저장
	@Override
	public int save(MemberDTO member) throws IllegalStateException, IOException {
		// dto에 담긴 파일을 가져옴 
		MultipartFile m_file = member.getM_file();
		// 파일 이름을 가져옴(파일이름을 DB에 저장하기 위해)
		String m_filename = m_file.getOriginalFilename();
		// 파일명 중복을 피하기 위해 파일이름앞에 현재 시간값을 붙임. 
		m_filename = System.currentTimeMillis() + "-" + m_filename;
		// 파일 저장 경로 세팅
		String savePath = "C:\\development\\source\\spring\\memberBoard\\src\\main\\webapp\\resources\\upload"+m_filename;
		// mfile이 비어있지 않다면(즉 파일이 있으면) savePath에 저장을 하겠다.
		// 실제 저장하는 코드
		if(!m_file.isEmpty()) {
			m_file.transferTo(new File(savePath));
		}
		// 여기까지의 내용은 파일을 저장하는 과정 
				
		// DB에 저장하기 위해 dto에 파일이름을 담는다.
		member.setM_filename(m_filename);
		
		int result = mr.save(member);
		return result;
	}
	
	// 회원가입시 아이디 중복확인
	@Override
	public String idDuplicate(String m_id) {
		String result = mr.idDuplicate(m_id);
		if(result == null) {
			return "ok"; // 조회결과가 없기 때문에 해당 아이디는 사용가능
		} else {
			return "no"; // 조회결과가 있기 때문에 해당 아이디는 사용불가능
		}
	}
	
	// 로그인
	@Override
	public String login(MemberDTO member) {
		MemberDTO loginMember = mr.login(member);
		if(loginMember != null) {
			// 로그인 성공(로그인 정보(아이디)를 세션에 저장)
			session.setAttribute("loginId", member.getM_id());
			session.setAttribute("loginPw", member.getM_password());
			session.setAttribute("loginNumber", loginMember.getM_number());
			return "main";
		}else {
			// 로그인 실패
			return "login";
		}
	}
	
	// 관리자가 회원목록 조회
	@Override
	public List<MemberDTO> findAll() {
		List<MemberDTO> memberList = mr.findAll();
		return memberList;
	}
	
	// 관리자가 원하는 회원 삭제
	@Override
	public void delete(long m_number) {
		mr.delte(m_number);
	}
	
	// 마이페이지에서 수정할 회원 찾기
	@Override
	public MemberDTO findById(long m_number) {
		MemberDTO member = mr.findById(m_number);
		return member;
	}
	
	// 회원정보 수정
	@Override
	public void update(MemberDTO member) {
		mr.update(member);
	}



	


	


}
