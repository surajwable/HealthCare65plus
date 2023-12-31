package com.demo.HealthCare65plus.config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.HealthCare65plus.beans.User;

public class UserPrincipal implements UserDetails{

	private static final long serialVersionUID = 2975571009655827897L;
	private User user;
	
	public UserPrincipal(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    
	    // Assuming that role is stored as a String in User class
	    String role = user.getRole();
	    
	    authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
	    
	    return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public int getUserId() {
		// TODO Auto-generated method stub
		return user.getUserId();
	}
}
