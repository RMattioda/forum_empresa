package com.empresas.forum.entity;

import java.io.Serializable;
import java.util.Objects;

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
	@Length(min=6, max=12, message = "Username deve ter entre 6 e 12 caracteres")
	private String username;
	
	@Column
	@Email
	private String email;
	
	@Column
	@NotEmpty(message="Senha não pode ser vazia")
	@Length(min=6, message="Senha deve possuir mínimo 6 caracteres")
	private String password;

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	
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
		User other = (User) obj;
		return Objects.equals(identity, other.identity);
	}
	
	
}
