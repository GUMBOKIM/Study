package com.example.toyproject.security.filter;

import com.example.toyproject.mapper.auth.AuthMapper;
import com.example.toyproject.security.model.UserModel;
import com.example.toyproject.security.tokenprovider.JwtTokenProvider;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
@Slf4j
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        String accessToken = jwtTokenProvider.resolveCookie(request);
//        String refreshToken = null;

        // access 토큰 검증 과정
        try {
            if (StringUtils.isNotBlank(accessToken) && jwtTokenProvider.validateToken(accessToken)) {
                Authentication auth = jwtTokenProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            // access 토큰 만료시 refresh 토큰 가져오기
        } catch (ExpiredJwtException e) {
//            UserModel memberModel = authMapper.findOneByUsername(.builder()
//                    .uid()
//                    .build());
//            if (ObjectUtils.isNotEmpty(memberModel)) {
//                refreshToken = memberModel.getToken();
//            }

            log.error("JWT expired error : {} ", e);
        } catch (Exception e) {
            System.out.println(e);
            SecurityContextHolder.clearContext();
            log.error("JWT filter internal error : {} ", e);
            return;
        }

        // refresh 토큰으로 access 토큰 재 발급
//        if (StringUtils.isNotBlank(refreshToken)) {
//            try {
//                try {
//                    if (jwtTokenProvider.validateToken(refreshToken)) {
//                        Authentication auth = jwtTokenProvider.getAuthentication(refreshToken);
//                        SecurityContextHolder.getContext().setAuthentication(auth);
//
//                        // 새로운 access 토큰 발급
//                        String newAccessToken = jwtTokenProvider.createToken(jwtTokenProvider.getClaims(refreshToken, "sub")).getAccessToken();
//                        jwtTokenProvider.createCookie(response, newAccessToken);
//                    }
//                } catch (ExpiredJwtException e) {
//                    SecurityContextHolder.clearContext();
//                    log.error("JWT expired error : {} ", e);
//                }
//            } catch (Exception e) {
//                SecurityContextHolder.clearContext();
//                log.error("JWT filter internal error : {} ", e);
//                return;
//            }
//        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        Collection<String> excludeUrlPatterns = new LinkedHashSet<>();
        excludeUrlPatterns.add("/api/auth/**");
        excludeUrlPatterns.add("/signup/**");
        excludeUrlPatterns.add("/resources/**");

        return excludeUrlPatterns.stream()
                .anyMatch(pattern -> new AntPathMatcher().match(pattern, request.getServletPath()));
    }

}