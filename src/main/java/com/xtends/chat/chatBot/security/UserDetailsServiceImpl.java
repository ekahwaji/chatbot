package com.xtends.chat.chatBot.security;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	public static UserDetails ChatUser = new User("chatbot"
			                                    , "Xtends2infinit*"
			                                    , true
			                                    , true
			                                    , true
			                                    , true
			                                    , Arrays.asList(new SimpleGrantedAuthority("ROLE_CHAT")));
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
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
