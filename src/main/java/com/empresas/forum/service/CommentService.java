package com.empresas.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresas.forum.entity.Comment;
import com.empresas.forum.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	public Comment insert(Comment comment) {
		return commentRepo.save(comment);
	}
}
