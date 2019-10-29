package com.empresas.forum.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Comment implements Serializable{
	private static final long serialVersionUID = 7671398563554866169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identity;
	
	@Column
	private User author;

	@Column
	private String commentary;
	
	@Column
	private LocalDateTime postDate = LocalDateTime.now();
	
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public Integer getIdentity() {
		return identity;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}

}
