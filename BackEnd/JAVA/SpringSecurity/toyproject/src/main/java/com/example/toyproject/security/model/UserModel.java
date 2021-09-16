package com.example.toyproject.security.model;

import com.example.toyproject.dto.auth.UserDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel extends UserDto implements Serializable, UserDetails {

    private String account;
    private String password;
    private String userGroup;
    private String nickName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList authority = new ArrayList();
        authority.add(userGroup);
        return authority;
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