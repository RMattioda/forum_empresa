package com.empresas.forum.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.key}")
	private String key;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	private String generateToken(String username) {
		return Jwts.builder().setSubject(username)
					.setExpiration(new Date(System.currentTimeMillis() + expiration))
					.signWith(SignatureAlgorithm.HS512, key.getBytes()).compact();
	}
}
