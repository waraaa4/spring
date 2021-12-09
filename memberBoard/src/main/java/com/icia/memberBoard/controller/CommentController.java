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
//		System.out.println(c_writer + " " + c_contents + " " + b_number);
		System.out.println("CommentController.save(): " + comment);
		
		/*
		 * 새로운 댓글을 DB에 저장하고
		 * 최신의 리스트를 DB에서 가져와서 ajax 쪽으로 리턴해야함.
		 * 이렇게 처리를 해야 화면 새로고침 없이 댓글이 실시간으로 추가되는 것처럼 보임. 
		 * 
		 * 댓글작성 하기
		 * 1. DB에 댓글을 저장한다.
		 * 2. DB로 부터 댓글 목록을 가져온다.(모두다 가져오는 것이 아니라 현재 게시글에 대한 댓글만 가져와야 함.)
		 * 3. 댓글 목록을 리턴한다.
		 * 
		 */
		cs.save(comment);
		List<CommentDTO> commentList = cs.findAll(comment.getB_number());
		
		return commentList;
	}

}
