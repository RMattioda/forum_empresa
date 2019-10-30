package com.empresas.forum.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(identity, other.identity);
	}

}
