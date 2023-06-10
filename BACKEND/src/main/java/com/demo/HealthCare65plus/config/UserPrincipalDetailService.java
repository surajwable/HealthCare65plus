package com.demo.HealthCare65plus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.HealthCare65plus.beans.User;
import com.demo.HealthCare65plus.dao.UserDao;


@Service
public class UserPrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private UserDao udao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = udao.getById(null);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		return userPrincipal;
	}
}
