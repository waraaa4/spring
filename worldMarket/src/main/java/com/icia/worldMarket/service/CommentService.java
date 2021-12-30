package com.icia.worldMarket.service;

import java.util.List;

import com.icia.worldMarket.dto.CommentDTO;

public interface CommentService {

	List<CommentDTO> findAll(long b_number);

	void save(CommentDTO comment);

}
