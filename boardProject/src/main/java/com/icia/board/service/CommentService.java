package com.icia.board.service;

import java.util.List;

import com.icia.board.dto.CommentDTO;

public interface CommentService {

	void save(CommentDTO comment);

	List<CommentDTO> findAll(long b_number);



}
