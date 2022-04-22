package com.springboot.rest.service;

import com.springboot.rest.repository.UsersRepository;
import com.springboot.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository usersRepository;

	public User loadUserByEmailId(String emailId) throws UsernameNotFoundException {
		try {
			User user = usersRepository.findByEmailId(emailId);
			return user;
		}
		catch (Exception e) {
			throw new UsernameNotFoundException("User not found with email id: " + emailId);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}