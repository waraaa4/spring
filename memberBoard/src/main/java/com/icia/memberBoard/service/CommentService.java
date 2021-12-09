package com.icia.memberBoard.service;

import java.util.List;

import com.icia.memberBoard.dto.CommentDTO;

public interface CommentService {

	List<CommentDTO> findAll(long b_number);

	void save(CommentDTO comment);

}
