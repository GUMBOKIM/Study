package com.example.toyproject.security.service;

import com.example.toyproject.mapper.auth.AuthMapper;
import com.example.toyproject.security.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component("LoginService")
public class LoginService implements UserDetailsService {

    private AuthMapper authMapper;

    public LoginService(AuthMapper auth){
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
