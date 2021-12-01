package com.icia.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;



@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	// 글작성 페이지로 이동
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm() {
		return "insert";
	}
	
	// 글작성 후 인덱스로 이동
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String sava(@ModelAttribute BoardDTO board) {
		int result = bs.insert(board);
		if(result > 0) {
			return "index";
		} else {
			return "insert";
		}
	}
	
	// 전체 글 목록
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<BoardDTO> boardList = bs.findAll();
		model.addAttribute("boardList",boardList);
		return "findAll";
	}
	
	
}
