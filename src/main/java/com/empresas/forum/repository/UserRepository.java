package com.empresas.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresas.forum.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
