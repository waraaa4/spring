package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public void saveFile(BoardDTO board) throws IllegalStateException, IOException {
		// dto에 담긴 파일을 가져옴 
		MultipartFile b_file = board.getB_file();
		// 파일 이름을 가져옴(파일이름을 DB에 저장하기 위해)
		String b_filename = b_file.getOriginalFilename();
		// 파일명 중복을 피하기 위해 파일이름앞에 현재 시간값을 붙임. 
		b_filename = System.currentTimeMillis() + "-" + b_filename;
		System.out.println("b_filename: " + b_filename);
		// 파일 저장 경로 세팅
		String savePath = "C:\\development\\source\\spring\\boardProject\\src\\main\\webapp\\resources\\upload\\"+b_filename;
		// bfile이 비어있지 않다면(즉 파일이 있으면) savePath에 저장을 하겠다.
		// 실제 저장하는 코드
		if(!b_file.isEmpty()) {
			b_file.transferTo(new File(savePath));
		}
		// 여기까지의 내용은 파일을 저장하는 과정 
		
		// DB에 저장하기 위해 dto에 파일이름을 담는다.
		board.setB_filename(b_filename);
		
		// DB의 board_table에 파일이름을 저장할 b_filename 이라는 컬럼 추가(타입은 varchar(100))
		br.saveFile(board);
	}

	

	
	
	
	
}
