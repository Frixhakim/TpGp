package com.todo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder passwordEncoder=passwordEncoder();
		System.out.println("************************");
		System.out.println(passwordEncoder.encode("123"));
		System.out.println("************************");
		
		// 
		//stockage des users en memoire
				
				auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("123")).roles("USER");
				auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("123")).roles("USER");
				auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("123")).roles("USER,ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		//l ordre mohime
		//1
		http.authorizeRequests().antMatchers("/save**/**","/delete**/**","/form**/**").hasRole("ADMIN");
        //2
		// tout les requetes http nessesite une authentification
		http.authorizeRequests().anyRequest().authenticated();
        http.csrf();
        http.exceptionHandling().accessDeniedPage("/notAutorized");
	}
	
	//pour chif Mdp
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
		
	}
}
