package com.spring.example.securityconfig;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


public class JwtServices {
	
	private final String SECERT ="qwertyuioplkjhgfdsa123zxc456bnm7";
	private Key key =Keys.hmacShaKeyFor(SECERT.getBytes());
	
	public String generatetoken(String username ,String role) {
		return Jwts.builder()
				.setSubject(username)
				.claim("role", role)
				.setExpiration(null)
				.setIssuedAt(null)
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}
	
	
	public String extractUsername(String token) {
		return getClaims(token).getSubject();
		
	}
	
	 public boolean validateToken(String token) {
	        try {
	            getClaims(token);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	

}
