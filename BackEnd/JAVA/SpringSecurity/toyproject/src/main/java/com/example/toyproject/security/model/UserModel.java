package com.example.toyproject.security.model;

import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Alias("UserModel")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel implements Serializable, UserDetails {

    private String account;
    private String password;
    private String userGroup;
    private String nickName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.getUserGroup()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.account;
    }

    @Override
    public String getPassword() {
        return this.password;
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
}