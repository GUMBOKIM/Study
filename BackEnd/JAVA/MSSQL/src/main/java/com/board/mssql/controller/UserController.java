package com.board.mssql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {



    @PostMapping("user/join")
    public String userJoin() {

        return "join";
    }
}
