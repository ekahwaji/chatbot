package com.xtends.chat.chatBot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.xtends.chat.chatBot.security.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(new UserDetailsServiceImpl());
		return provider;
	}
	
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	public BasicAuthenticationFilter securityFilter() throws Exception
	{
		BasicAuthenticationFilter authenticationFilter = new BasicAuthenticationFilter(authenticationManager() );
		
		return authenticationFilter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		   .authorizeRequests()
		   .antMatchers(HttpMethod.POST, "/dialogFlow/**")
		   .access("hasRole('ROLE_CHAT')")
		   .and()
		   .csrf().disable()
		   .exceptionHandling().authenticationEntryPoint(new BasicAuthenticationEntryPoint())
		   .and()
		   .addFilterAt(securityFilter(), BasicAuthenticationFilter.class);
	}
}
