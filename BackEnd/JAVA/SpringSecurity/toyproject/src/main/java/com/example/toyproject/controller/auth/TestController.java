package com.example.toyproject.controller.auth;

import com.example.toyproject.dto.auth.AuthMapDto;
import com.example.toyproject.mapper.auth.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final UserMapper authMapper;

    @GetMapping("/test")
    public String QueryTester() {
        System.out.println("진입");
        List<AuthMapDto> result = authMapper.findGroupUrlMap();
        System.out.println("가져오기 성공");
        System.out.println(result);
        System.out.println(result);
        return "OK TEST";
    }
}
