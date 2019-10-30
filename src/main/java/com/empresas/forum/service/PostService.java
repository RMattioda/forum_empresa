package com.empresas.forum.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresas.forum.entity.Comment;
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
	
	public List<Post> findAll(){
		return postRepo.findAll().stream()
				.sorted((o1, o2) -> o1.getPostDate().compareTo(o2.getPostDate()))
				.collect(Collectors.toList());
	}
	
	
	public Post insert(Post post) {
		return postRepo.save(post);
	}
	
	public void insertComment(Post post, Comment comment) {
		List<Comment> postComments = getComments(post);
		postComments.add(comment);
		post.setComments(postComments);
		postRepo.save(post);
	}
	
	public void deletePost(Integer id) {
		postRepo.deleteById(id);
	}
	
	private List<Comment> getComments(Post post) {
		return post.getComments();
	}
	
}
