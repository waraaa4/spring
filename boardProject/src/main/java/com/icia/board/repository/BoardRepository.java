package com.icia.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSessionTemplate sql;

	public int insert(BoardDTO board) {
		return sql.insert("Board.insert", board);
	}

	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
	}
	
}
