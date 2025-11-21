package com.spring.example.securityconfig;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

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
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
				.setIssuedAt(new Date())
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}
	
	
	public String extractUsername(String token) {
		return getClaims(token).getSubject();
		
	}
	
	 
	
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public Boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
		}
	    
	public Boolean isTokenValid(String token,UserDetails userDetails) {
		String username = extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	    }
	
	
	

}
