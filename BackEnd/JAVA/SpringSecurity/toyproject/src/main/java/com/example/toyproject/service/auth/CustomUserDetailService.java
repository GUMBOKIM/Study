package com.example.toyproject.service.auth;


import com.example.toyproject.dto.auth.UserDto;
import com.example.toyproject.mapper.auth.AuthMapper;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {
    private final AuthMapper authMapper;

    public CustomUserDetailService(AuthMapper authMapper){
        this.authMapper = authMapper;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        UserDto userdto = authMapper.findOneByUsername(account);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userdto.getUserGroup()));
        return new User(userdto.getAccount(), userdto.getPassword(), authorities);
    }

}
