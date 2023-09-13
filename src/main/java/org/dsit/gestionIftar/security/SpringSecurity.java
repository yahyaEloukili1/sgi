package org.dsit.gestionIftar.security;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.*;



@EnableWebSecurity
public class SpringSecurity extends  WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	@Override
	protected void configure(HttpHeaderSecurityFilter http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.formLogin();
		http.authorizeRequests().antMatchers("/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
}
