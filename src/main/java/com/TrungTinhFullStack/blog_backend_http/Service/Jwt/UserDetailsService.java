package com.TrungTinhFullStack.blog_backend_http.Service.Jwt;

import com.TrungTinhFullStack.blog_backend_http.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsernameAndEnabled(username,true);
    }
}
