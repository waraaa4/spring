package com.icia.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;

// /board/* 주소를 모두 처리
@Controller
@RequestMapping(value="/board/*") // /board/* 로 요청하는 주소는 다 받겠다
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	// 글작성 페이지로 이동
	@RequestMapping(value = "save", method = RequestMethod.GET)
	public String saveForm() {
		// views/board 폴더에 있는 save.jsp를 출력
		return "board/save";
	}
	
	// 글작성 후 게시글 목록 조회
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute BoardDTO board) {
		bs.save(board);
		return "redirect:/board/findAll";
	}
	
	// 게시글 목록 조회
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<BoardDTO> boardList = bs.findAll();
		model.addAttribute("boardList", boardList);
		return "board/findAll";
	}
	
	// 선택한 게시글 조회
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String findById(@RequestParam("b_number") long b_number, Model model, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		bs.hits(b_number);
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		model.addAttribute("page", page); //detail.jsp로 갈 때 page값을 가지고감.
		return "board/detail";
	}
	
	// 게시글 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("b_number") long b_number) {
		bs.delete(b_number);
		return "redirect:/board/findAll";
	}
	
	// 게시글 수정하는 페이지 이동
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm(@RequestParam("b_number") long b_number, Model model, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		return "board/update";
	}
	
	// 회원수정을 완료하고 그 회원을 detail 페이지에 출력
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO board, Model model, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		bs.update(board);
		return "redirect:/board/detail?b_number="+board.getB_number() + "&page=" + page;
	}
	
	// 회원목록 페이징 처리
	@RequestMapping(value="paging", method=RequestMethod.GET)
	// value: 파라미터이름, required: 필수여부, defaultValue: 기본값(page 요청값이 없으면 1로 세팅)
	public String paging(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		List<BoardDTO> boardList = bs.pagingList(page);
		PageDTO paging = bs.paging(page);
		model.addAttribute("boardList", boardList);
		model.addAttribute("paging", paging);
		return "board/findAll";
	}
	
	// 검색
	@RequestMapping(value = "search", method=RequestMethod.GET)
	public String search(@RequestParam("searchtype") String searchtype, @RequestParam("keyword") String keyword, Model model) {
		List<BoardDTO> boardList = bs.search(searchtype, keyword);
		model.addAttribute("boardList", boardList);
		return "board/findAll";
	}
	
	
	
	
	
	
	
	
	
	
}
