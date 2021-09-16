package com.example.toyproject.controller.auth;

import com.example.toyproject.dto.auth.UserDto;
import com.example.toyproject.mapper.auth.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/path")
@RequiredArgsConstructor
public class PathController {

    private final AuthMapper authMapper;

    @GetMapping("/guest/board")
    public String getGuestBoard() {
        return "Guest";
    }

    @GetMapping("/user/{userName}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity findOneByUser(@PathVariable("userName") String userName) {
        System.out.println(userName);
        UserDto userDto = authMapper.findOneByUsername(userName);
        System.out.println("매퍼 끝");
        if (userDto.getAccount() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }

    @GetMapping("/manager/{userName}")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public ResponseEntity findOneByManagerAndAdmin(@PathVariable("userName") String userName) {
        System.out.println(userName);
        UserDto userDto = authMapper.findOneByUsername(userName);
        if (userDto.getAccount() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }

    @PreAuthorize("permitAll")
    @GetMapping("/all/myself")
    public ResponseEntity findOneByManagerAndAdmin(@AuthenticationPrincipal User user) {
        UserDto userDto = authMapper.findOneByUsername(user.getUsername());
        if (userDto.getAccount() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }

    // DefaultWebSecurityExpressionHandler에서 defaultRolePrefix를 수정하여 커스터마이즈할 수 있습니다. - https://offbyone.tistory.com/91
    // 로그인한 사용자 정보 - https://coco-log.tistory.com/129
}
