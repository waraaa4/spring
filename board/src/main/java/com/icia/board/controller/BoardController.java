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
	
	@RequestMapping(value="save", method=RequestMethod.GET)
	public String saveForm() {
		// views/board 폴더에 있는 save.jsp를 출력 
		return "board/save";
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@ModelAttribute BoardDTO board) {
		bs.save(board);
		return "redirect:/board/findAll";
	}
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		List<BoardDTO> boardList = bs.findAll();
		model.addAttribute("boardList", boardList);
		return "board/findAll";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String findById(@RequestParam("b_number") long b_number, Model model) {
		bs.hits(b_number);
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("b_number") long b_number) {
		bs.delete(b_number);
		return "redirect:/board/findAll";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateForm(@RequestParam("b_number") long b_number, Model model) {
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		return "board/update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO board) {
		bs.update(board);
		return "redirect:/board/detail?b_number="+board.getB_number();
	}
	
}








