package com.board.mssql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("user/login")
    public String userLogin(){

        return "user/user_login";
    }

    @GetMapping("user/join")
    public String userJoin(){

        return "user/user_join";
    }

    @GetMapping("board/create")
    public String boardCreate() {

        return "board/board_create";
    }

    @GetMapping("board/list")
    public String boardList() {

        return "board/board_list";
    }

    @GetMapping("aticle/list")
    public String articleList(){
        return "article/article_list";
    }

    @GetMapping("article/post")
    public String articlePost() {
        return "article/article_post";
    }

    @GetMapping("article/article_read")
    public String articleRead(){
        return "article/article_read";
    }


}
