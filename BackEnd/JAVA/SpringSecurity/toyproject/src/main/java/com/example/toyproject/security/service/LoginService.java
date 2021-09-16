package com.example.toyproject.security.service;

import com.example.toyproject.mapper.auth.AuthMapper;
import com.example.toyproject.security.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel resMemberModel = (UserModel) authMapper.findOneByUsername(username);

        if (resMemberModel == null) {
            throw new UsernameNotFoundException("ID : '" + username + "' not found");
        }
        return resMemberModel;
    }

}
