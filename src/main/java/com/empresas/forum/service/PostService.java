package com.empresas.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresas.forum.entity.Post;
import com.empresas.forum.repository.PostRepository;
import com.empresas.forum.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepo;
	
	public Post findById(Integer id) {
		Optional<Post> post = postRepo.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException(
				"Post não encontrado! Id: " +id + ", Tipo: " + Post.class.getName()));
	}
	
	public Post insert(Post post) {
		return postRepo.save(post);
	}
}
