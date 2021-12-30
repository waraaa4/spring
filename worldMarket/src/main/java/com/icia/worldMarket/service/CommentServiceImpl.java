package com.icia.worldMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.worldMarket.dto.CommentDTO;
import com.icia.worldMarket.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository cr;

	@Override
	public List<CommentDTO> findAll(long b_number) {
		return cr.findAll(b_number);
	}

	@Override
	public void save(CommentDTO comment) {
		cr.save(comment);
	}
		
}
