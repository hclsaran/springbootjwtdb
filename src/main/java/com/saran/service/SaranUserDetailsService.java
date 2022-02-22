package com.saran.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.saran.model.DAOUser;
import com.saran.model.UserDTO;
import com.saran.repo.UserRepository;
@Service
public class SaranUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user=repo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found with this username"+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				new ArrayList<>());
	    }
	
	public DAOUser save(UserDTO user) {
		
		DAOUser newUser=new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword())); //automatically encrypted storing your pwd as hashing
		return repo.save(newUser);
		
	}
}
