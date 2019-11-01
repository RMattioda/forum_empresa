package com.empresas.forum.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.empresas.forum.entity.Comment;
import com.empresas.forum.entity.Post;
import com.empresas.forum.service.CommentService;
import com.empresas.forum.service.PostService;

@RestController
@RequestMapping(value = "/posts/{postId}/comment")
public class CommentResource {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity<Void> insertComment(
			@PathVariable Integer postId,
			@Valid @RequestBody Comment comment) {

		Post post = postService.findById(postId);
		comment = commentService.insert(comment);
		postService.insertComment(post, comment);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("?id=/{id}").buildAndExpand(comment.getIdentity()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
