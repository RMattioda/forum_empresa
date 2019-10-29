package com.empresas.forum.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.empresas.forum.entity.Comment;
import com.empresas.forum.entity.User;

public class PostDto implements Serializable {
	private static final long serialVersionUID = -6790058376672799266L;

	private String title;
	
	private String body;
	
	private LocalDateTime postDate;
	
	private List<Comment> comments;
	
	private User author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
}
