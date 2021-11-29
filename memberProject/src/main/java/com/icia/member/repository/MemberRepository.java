package com.icia.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

//스프링이 관리 하기 위해서 필요
@Repository 
public class MemberRepository {
	
	// mapper 사용을 위해서 필요
	@Autowired
	private SqlSessionTemplate sql;
	
	public int save(MemberDTO member) {
		System.out.println("MemberRepositroy.save(): " + member);
		return sql.insert("Member.save", member);
	}

	public MemberDTO login(MemberDTO member) {
		return sql.selectOne("Member.login", member);
	}

	public List<MemberDTO> findAll() {
		return sql.selectList("Member.findAll");
	}

	public MemberDTO findById(long m_number) {
		return sql.selectOne("Member.findById", m_number);
	}

	

}
