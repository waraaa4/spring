package com.icia.memberBoard.service;

import java.io.IOException;
import java.util.List;

import com.icia.memberBoard.dto.MemberDTO;

public interface MemberService {

	int save(MemberDTO member) throws IllegalStateException, IOException;

	String idDuplicate(String m_id);

	String login(MemberDTO member);

	List<MemberDTO> findAll();

	void delete(long m_number);

	MemberDTO findById(long m_number);

	void update(MemberDTO member);





	

}
