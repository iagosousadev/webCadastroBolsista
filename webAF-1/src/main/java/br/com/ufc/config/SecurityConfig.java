package br.com.ufc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import br.com.ufc.security.UserDetailsServiceImplement;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsServiceImplement userDetailsServiceImplement;
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/").permitAll()
		.antMatchers("/aluno/cadastro").permitAll()
		.antMatchers("/aluno/salvar").permitAll()
		.antMatchers("/aluno/bemvindo").hasRole("ALUNO")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/aluno/login")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.permitAll();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsServiceImplement);
		
	}
	
	
	
}
