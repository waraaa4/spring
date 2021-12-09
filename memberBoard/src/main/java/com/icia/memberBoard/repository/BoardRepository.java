package com.icia.memberBoard.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberBoard.dto.BoardDTO;



@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	// 게시글 작성
	public void save(BoardDTO board) {
		sql.insert("Board.save", board);
	}
	
	// 게시글 목록 
	public List<BoardDTO> pagingList(int pagingStart) {
		return sql.selectList("Board.pagingList", pagingStart);
	}

	public List<BoardDTO> pagingList1(Map<String, Integer> pagingParam) {
		return sql.selectList("Board.pagingList1", pagingParam);
	}

	public int boardCount() {
		return sql.selectOne("Board.count");
	}
	
	// 검색
	public List<BoardDTO> search(Map<String, String> serchParam) {
		return sql.selectList("Board.search", serchParam);
	}
	
	// 조회수 증가
	public void hits(long b_number) {
		sql.update("Board.hits", b_number);
	}
	
	// 아이디 찾기
	public BoardDTO findById(long b_number) {
		return sql.selectOne("Board.findById", b_number);
	}
	
	// 회원찾기
	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
	}
	
	// 게시글 수정하고 되돌아가기
	public void update(BoardDTO board) {
		sql.update("Board.update", board);
	}
	
	// 게시글 삭제
	public void delete(long b_number) {
		sql.delete("Board.delete", b_number);
	}



	
	
}
