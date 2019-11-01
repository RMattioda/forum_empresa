package com.empresas.forum.dto;

import java.io.Serializable;

public class CredentialsDto implements Serializable{
	private static final long serialVersionUID = 5113314481777107689L;
	
	private String email;
	private String password;
	
	public CredentialsDto() {
	}
	
	public CredentialsDto(String email, String password) {
		this.email = email;
		this.password = password;
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
