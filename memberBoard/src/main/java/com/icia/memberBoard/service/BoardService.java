package com.icia.memberBoard.service;

import java.io.IOException;
import java.util.List;

import com.icia.memberBoard.dto.BoardDTO;
import com.icia.memberBoard.dto.PageDTO;


public interface BoardService {
	
	public List<BoardDTO> pagingList(int page);

	public PageDTO paging(int page);
	
	void save(BoardDTO board) throws IllegalStateException, IOException;
	
	List<BoardDTO> search(String searchtype, String keyword);

	public void hits(long b_number);

	public BoardDTO findById(long b_number);

	public List<BoardDTO> findAll(long m_number);

	public void update(BoardDTO board);

	public void delete(long b_number);





	

	
}
