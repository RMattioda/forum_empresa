package com.empresas.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresas.forum.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	
}
