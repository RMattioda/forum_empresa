package com.empresas.forum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 3528432954270048061L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer identity;
	
	@Column
	@NotEmpty(message="Nome de usuário inválido")
	@Length(min=6, max=12)
	private String username;
	
	@Column
	@Email
	private String email;
	
	@Column
	@NotEmpty(message="Senha não pode ser vazia")
	@Length(min=6, max=12, message="Senha deve possuir entre 6 e 12 caracteres")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
