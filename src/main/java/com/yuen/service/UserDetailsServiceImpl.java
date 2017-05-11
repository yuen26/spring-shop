package com.yuen.service;

import com.yuen.domain.web.CustomUserDetails;
import com.yuen.domain.web.Role;
import com.yuen.domain.web.User;
import com.yuen.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional(readOnly = true)
    public CustomUserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Get roles of user
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);
        customUserDetails.setAuthorities(authorities);
        
        return customUserDetails;
    }

}