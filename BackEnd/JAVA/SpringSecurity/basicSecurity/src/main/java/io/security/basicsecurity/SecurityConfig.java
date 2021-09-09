package io.security.basicsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 인증 정책 -> 어떤 요청이든지 -> 검증요함
        http.authorizeRequests()
                .anyRequest().authenticated();

        // 인가 정책 -> 폼 로그인
        http
                .formLogin() //폼으로 로그인
                .loginPage("/loginpage") //로그인 페이지 경로
                .defaultSuccessUrl("/default") //로그인 성공후 URL
                .failureUrl("/failure") // 로그인 실패후 URL
                .loginProcessingUrl("/login_proc") //form 태그 action
                .successHandler(new AuthenticationSuccessHandler() { // 로그인 성공시 핸들러
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
                        System.out.println("authentication" + auth.getName());
                        res.sendRedirect("/");
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() { // 로그인 실패시 핸들러
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
                        System.out.println("exception" + e.getMessage());
                        res.sendRedirect("/");
                    }

    });

    }

}
