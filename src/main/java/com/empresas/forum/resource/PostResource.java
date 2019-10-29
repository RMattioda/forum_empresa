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

import com.empresas.forum.entity.Post;
import com.empresas.forum.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Post> getPost(){
		
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Integer id){
		
		Post post = postService.findById(id);
		
		return ResponseEntity.ok(post);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> newPost(@RequestBody Post post){
		
		post = postService.insert(post); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(post.getIdentity()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
