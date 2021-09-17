package com.example.toyproject.controller.auth;

import com.example.toyproject.dto.auth.*;
import com.example.toyproject.mapper.auth.UserMapper;
import com.example.toyproject.security.model.JwtModel;
import com.example.toyproject.security.tokenprovider.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Value("${jwt.header-name}")
    private String HEADER_NAME;

    public UserController(JwtTokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserMapper authMapper) {
        this.jwtTokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getAccount(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        JwtModel jwt = jwtTokenProvider.createToken(authentication);
        jwtTokenProvider.createCookie(response, jwt.getAccessToken());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        String[] cookieList = {"JSESSIONID", HEADER_NAME};
        deleteCookie(request, response, cookieList);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void deleteCookie(HttpServletRequest request, HttpServletResponse response, String[] cookiesToClear) {
        for (String cookieName : cookiesToClear) {
            Cookie cookie = new Cookie(cookieName, null);
            String cookiePath = request.getContextPath() + "/";
            cookie.setPath(cookiePath);
            cookie.setMaxAge(0);
            cookie.setSecure(request.isSecure());
            response.addCookie(cookie);
        }
    }


}