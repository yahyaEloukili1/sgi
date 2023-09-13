package org.dsit.gestionIftar.security;

import java.io.IOException;
import java.util.Date;

import org.dsit.gestionIftar.entities.AppUser;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.persistence.*;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		AppUser appUser = null;
		try {
			appUser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("***************");
		System.out.print("Username: "+appUser.getUsername());
		System.out.print("password: "+appUser.getPassword());
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
	}
	 @Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User springUser = (User) authResult.getPrincipal();
		String jwt = Jwts.builder().setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				.claim("roles", springUser.getAuthorities())
				.compact();
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
		//super.successfulAuthentication(request, response, chain, authResult);
	}
}
