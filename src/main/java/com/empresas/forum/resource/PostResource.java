package com.empresas.forum.resource;

import java.net.URI;
import java.util.List;

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
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getPosts(){
		
		List<Post> allPosts = postService.findAll();
		
		return ResponseEntity.ok(allPosts);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Integer id){
		
		Post post = postService.findById(id);
		
		return ResponseEntity.ok(post);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> newPost(@Valid @RequestBody Post post){
		
		post = postService.insert(post); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(post.getIdentity()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ResponseEntity<Void> newComment(@Valid @RequestBody Comment comment,
						@PathVariable Integer id){
		
		Post post = postService.findById(id);
		comment = commentService.insert(comment); 
		postService.insertComment(post, comment);
		
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	private ResponseEntity<Void> deletePost(@PathVariable Integer id){
		
		postService.deletePost(id); 
		
		return ResponseEntity.noContent().build();
	}
}
