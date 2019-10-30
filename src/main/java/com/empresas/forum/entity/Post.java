package com.empresas.forum.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Post implements Serializable{
	private static final long serialVersionUID = -7751000149540624997L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identity;
	
	@Column
	@NotBlank
	@Length(min = 10)
	private String title;
	
	@Column
	@NotBlank
	@Length(min = 10)
	private String body;
	
	@JoinColumn
	@ManyToOne
	private User author;
	
	@Column
	private LocalDateTime postDate = getIntant();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "post_comments",
			joinColumns = @JoinColumn(name="post_id"),
			inverseJoinColumns = @JoinColumn(name = "comment_id"))
	private List<Comment> comments = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="urls")
	private List<String> urlImages;

	public Integer getIdentity() {
		return identity;
	}

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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate.atZone(ZoneId.systemDefault());
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<String> getUrlImages() {
		return urlImages;
	}

	public void setUrlImages(List<String> urlImages) {
		this.urlImages = urlImages;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
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
		Post other = (Post) obj;
		return Objects.equals(identity, other.identity);
	}
	
	private LocalDateTime getIntant() {
		return LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
	}
	
}
