package com.icia.memberBoard.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.memberBoard.dto.BoardDTO;
import com.icia.memberBoard.dto.CommentDTO;
import com.icia.memberBoard.dto.PageDTO;
import com.icia.memberBoard.service.BoardService;
import com.icia.memberBoard.service.CommentService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private CommentService cs;
	
	// 게시글 목록
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	// value: 파라미터이름, required: 필수여부, defaultValue: 기본값(page 요청값이 없으면 1로 세팅)
	public String findAll(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		List<BoardDTO> boardList = bs.pagingList(page);
		PageDTO paging = bs.paging(page);
		model.addAttribute("boardList", boardList);
		model.addAttribute("paging", paging);
		return "board/findAll";
	}
	
	// 게시글 작성 페이지 이동
	@RequestMapping(value = "save", method = RequestMethod.GET)
	public String saveForm() {
		return "board/save";
	}
		
	// 글작성 후 게시글 목록 조회
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		bs.save(board);
		return "redirect:/board/findAll";
	}
	
	// 검색
	@RequestMapping(value = "search", method=RequestMethod.GET)
	public String search(@RequestParam("searchtype") String searchtype, @RequestParam("keyword") String keyword, Model model) {
		List<BoardDTO> boardList = bs.search(searchtype, keyword);
		model.addAttribute("boardList", boardList);
		return "board/findAll";
	}
	
	// 선택한 게시글 조회
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String findById(@RequestParam("b_number") long b_number, Model model, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		bs.hits(b_number);
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		List<CommentDTO> commentList = cs.findAll(b_number);
		model.addAttribute("commentList", commentList);
		return "board/detail";
	}
	
	// 게시글 수정하는 페이지 이동
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm(@RequestParam("b_number") long b_number, Model model, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		return "board/update";
	}
	
	// 게시글 수정완료 하고 detail 페이지에 출력
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO board, Model model, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		bs.update(board);
		System.out.println(board.getB_number()+"asd");
		return "redirect:/board/detail?b_number="+board.getB_number() + "&page=" + page;
	}
	
	// 게시글 삭제
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("b_number") long b_number) {
		bs.delete(b_number);
		return "redirect:/board/findAll";
	}
	
	
	
	
	
	
	
}
