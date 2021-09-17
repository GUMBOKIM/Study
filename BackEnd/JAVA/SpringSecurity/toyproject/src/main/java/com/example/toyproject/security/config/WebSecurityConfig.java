package com.example.toyproject.security.config;

import com.example.toyproject.security.entrypoint.JwtAuthenticationEntryPoint;
import com.example.toyproject.security.filter.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /* (1) */
    @Value("${jwt.header-name}")
    private String HEADER_NAME;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* (2) */
        http.csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        /* (3) */
        http.headers()
                .cacheControl().disable()
                .frameOptions().sameOrigin();

        /* (4) */
        http.authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/home/guest/**").permitAll()
                .anyRequest().authenticated();

        http.logout().logoutUrl("/api/auth/logout").permitAll()
                .deleteCookies("JSESSIONID")
                .deleteCookies(HEADER_NAME)
                .logoutSuccessUrl("/api/auth/login")
                .invalidateHttpSession(true);

        http.exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint);

        /* (7) */
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /* (8) */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring();
        web.httpFirewall(defaultHttpFirewall());
    }

    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }

}