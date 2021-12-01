package com.icia.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository br;
	
	@Autowired
	private HttpSession session;

	public int insert(BoardDTO board) {
		int result = br.insert(board);
		return result;
	}

	public List<BoardDTO> findAll() {
		List<BoardDTO> boardList = br.findAll();
		return boardList;
	}

	
	
	
}
