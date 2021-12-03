package com.icia.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository br;
	
	@Override
	public void save(BoardDTO board) {
		br.save(board);
	
	}

	@Override
	public List<BoardDTO> findAll() {
//		List<BoardDTO> boardList = br.findAll();
//		return boardList;
		return br.findAll();
	}
	
	@Override
	public void hits(long b_number) {
		br.hits(b_number);
		
	}

	@Override
	public BoardDTO findById(long b_number) {
		// 1.조회수증가 2.상세조회
		br.hits(b_number);
		return br.findById(b_number);
	}

	@Override
	public void delete(long b_number) {
		br.delete(b_number);
	}

	@Override
	public void update(BoardDTO board) {
		br.update(board);
	}
	
	// 상수는 이름을 대부분 대문자로 작성
	private static final int PAGE_LIMIT = 3; // 한페이지에 보여질 글 개수 
	private static final int BLOCK_LIMIT = 3; // 한화면에 보여질 페이지 개수

	@Override
	public List<BoardDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		// 1페이지 limit 0,3 2페이지 3,3 3페이지 6,3
		int pagingStart = (page-1) * PAGE_LIMIT;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
//		List<BoardDTO> pagingList = br.pagingList(pagingStart);
		List<BoardDTO> pagingList = br.pagingList1(pagingParam);
		for(BoardDTO b: pagingList) {
			System.out.println(b.toString());
		}
		return pagingList;
	}

	@Override
	public PageDTO paging(int page) {
		// 전체 글 갯수 조회
		int boardCount = br.boardCount(); 
		// 전체 페이지 계산
		int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT)); 
		// 2페이지를 요청했으면 1페이지, 4페이지를 요청했으면 4페이지, 8페이지를 요청했으면 7페이지의 값을 갖도록 계산
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		if(endPage > maxPage)
			endPage = maxPage; 
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		System.out.println("paging.toString(): "+ paging.toString());
		
		return paging;
	}

	@Override
	public List<BoardDTO> search(String searchtype, String keyword) {
		Map<String, String> serchParam = new HashMap<String, String>();
		serchParam.put("type", searchtype);
		serchParam.put("word", keyword);
		List<BoardDTO> boardList = br.search(serchParam);
		return boardList;
	}

	

	
	
	
	
}
