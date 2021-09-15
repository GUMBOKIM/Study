package com.example.toyproject.service.auth.user;

import com.example.toyproject.dto.auth.JoinUserDto;
import com.example.toyproject.dto.auth.UserDto;
import com.example.toyproject.mapper.auth.AuthMapper;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService {
//    private final AuthMapper authMapper;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserService(AuthMapper authMapper, PasswordEncoder passwordEncoder) {
//        this.authMapper = authMapper;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Transactional
//    public User signup(JoinUserDto joinUserDto) throws DuplicateMemberException {
//        if (authMapper.findOneByUsername(joinUserDto.getAccount()) != null) {
//            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
//        }
//
//        return authMapper.joinUser(joinUserDto);
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<User> getUserWithAuthorities(String username) {
//        return userRepository.findOneWithAuthoritiesByUsername(username);
//    }
//
//    @Transactional(readOnly = true)
//    public Optional<User> getMyUserWithAuthorities() {
//        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
//    }
//
//    private static class Authority {
//    }
}