package com.icia.memberBoard.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberBoard.dto.MemberDTO;

@Repository 
public class MemberRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	// 회원가입
	public int save(MemberDTO member) {
		return sql.insert("Member.save", member);
	}
	
	// 회원가입 아이디 중복확인
	public String idDuplicate(String m_id) {
		return sql.selectOne("Member.idDuplicate", m_id);
	}
	
	// 로그인
	public MemberDTO login(MemberDTO member) {
		return sql.selectOne("Member.login", member);
	}
	
	// 관리자가 회원목록 조회
	public List<MemberDTO> findAll() {
		return sql.selectList("Member.findAll");
	}
	
	// 관리자가 원하는 회원 삭제
	public void delte(long m_number) {
		sql.delete("Member.delete", m_number);
	}
	
	// 마이페이지에서 수정할 회원 찾기
	public MemberDTO findById(long m_number) {
		return sql.selectOne("Member.findById", m_number);
	}
	
	// 회원정보 수정
	public void update(MemberDTO member) {
		sql.update("Member.update", member);
	}
	

	
	
}
