package com.icia.memberBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.memberBoard.dto.CommentDTO;
import com.icia.memberBoard.service.CommentService;


@Controller
@RequestMapping("/comment/*")
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public void save(@RequestParam("c_writer") String c_writer, @RequestParam("c_contents") String c_contents, @RequestParam("b_number") long b_number) {
	public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO comment) {

		cs.save(comment);
		List<CommentDTO> commentList = cs.findAll(comment.getB_number());
		
		return commentList;
	}

}
