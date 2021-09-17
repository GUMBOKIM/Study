package com.example.toyproject.security.service;

import com.example.toyproject.mapper.auth.UserMapper;
import com.example.toyproject.security.model.UserModel;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("LoginService")
public class LoginService implements UserDetailsService {

    private UserMapper authMapper;

    public LoginService(UserMapper auth){
        this.authMapper = auth;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel res = authMapper.findOneByUsername(username);

        if (res == null) {
            throw new UsernameNotFoundException("ID : '" + username + "' not found");
        }

        return new User(res.getUsername(), res.getPassword(), res.getAuthorities());
    }

}
