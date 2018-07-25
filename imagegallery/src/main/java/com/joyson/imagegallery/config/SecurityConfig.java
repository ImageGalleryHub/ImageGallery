package com.joyson.imagegallery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.joyson.imagegallery.services.UserService;

/**
 * Security configuration for image gallery app
 * 
 * @author Joyson De Souza
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().disable() // disable form authentication
				.anonymous().disable() // disable anonymous user
				.httpBasic().and().authorizeRequests().anyRequest().authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = passwordEncoder();
		/*auth.inMemoryAuthentication() // creating user in memory
				.passwordEncoder(encoder).withUser("user").password(encoder.encode("password")).roles("USER").and()
				.withUser("admin").password(encoder.encode("password")).authorities("ROLE_ADMIN");*/
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// provides the default AuthenticationManager as a Bean
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
