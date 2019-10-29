package com.empresas.forum.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Post implements Serializable{
	private static final long serialVersionUID = -7751000149540624997L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identity;
	
	@Column
	@NotEmpty
	@Length(min = 10)
	private String title;
	
	@Column
	@NotEmpty
	@Length(min = 10)
	private String body;
	
	@JoinColumn
	@ManyToOne
	private User author;
	
	@Column
	private LocalDateTime postDate;
	
	@ManyToMany
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
}
