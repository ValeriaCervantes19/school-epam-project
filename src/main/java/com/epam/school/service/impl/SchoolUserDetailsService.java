package com.epam.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.school.entities.EpamUser;
import com.epam.school.repository.UserRepository;

@Service
public class SchoolUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final EpamUser user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetails userDetails = User.withDefaultPasswordEncoder().username(user.getUsername()).
				password(user.getPassword()).authorities("USER").build();
		//GrantedAuthority granted  = new SimpleGrantedAuthority("ROL"); // pasar toda la colección
		return userDetails;							
	}
}
