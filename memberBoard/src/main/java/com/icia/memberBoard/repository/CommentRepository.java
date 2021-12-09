package com.icia.memberBoard.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberBoard.dto.CommentDTO;

@Repository
public class CommentRepository {
	
	@Autowired
	private SqlSessionTemplate sql;

	public List<CommentDTO> findAll(long b_number) {
		return sql.selectList("Comment.findAll", b_number);
	}
	
	public void save(CommentDTO comment) {
		sql.insert("Comment.save", comment);
	}
	
}
