package com.xtends.chat.chatBot.security;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	public static UserDetails ChatUser = new User("chatbot"
			                                    , "Xtends2infinit*"
			                                    , true
			                                    , true
			                                    , true
			                                    , true
			                                    , Arrays.asList(new SimpleGrantedAuthority("ROLE_CHAT")));
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("loadUserByUsername for username:"+username);
		
		if("chatbot".equals(username))
		{
			return ChatUser;
		}
		else
		{
			throw new UsernameNotFoundException("User not found");
		}
	}
}
