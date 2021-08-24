package com.board.mssql.controller;

import com.board.mssql.dto.UserDto;
import com.board.mssql.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    UserMapper userMapper;

    @PostMapping("user/join")
    public Long userJoin(UserDto userDto) {
        Long userId = userMapper.createUser(userDto);
        return userId;
    }

    @GetMapping("user/login")
    public ResponseEntity userLogin(@RequestBody UserDto userdto) {
        Long userId = userMapper.loginUser(userdto);

        return new ResponseEntity<>(userId, HttpStatus.OK);

    }

    @GetMapping("user/findByAccount/{userId}")
    public ResponseEntity userFindByUserId(@PathVariable("userId") Long userId) {
        UserDto userDto = userMapper.findUserByUserId(userId);
        if (userDto.getUserId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }


    @GetMapping("user/findById/{account}")
    public ResponseEntity userFindByAccount(@PathVariable("account") String account) {
        UserDto userDto = userMapper.findUserByAccount(account);
        if (userDto.getUserId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }
}
