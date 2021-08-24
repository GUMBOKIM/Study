package com.board.mssql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("user/login_page")
    public String userLogin(){

        return "user/user_login";
    }

    @GetMapping("user/join_page")
    public String userJoin(){

        return "user/user_join";
    }

    @GetMapping("board/create_page")
    public String boardCreate() {

        return "board/board_create";
    }

    @GetMapping("board/list_page")
    public String boardList() {

        return "board/board_list";
    }

    @GetMapping("aticle/list_page")
    public String articleList(){
        return "article/article_list";
    }

    @GetMapping("article/post_page")
    public String articlePost() {
        return "article/article_post";
    }

    @GetMapping("article/article_page")
    public String articleRead(){
        return "article/article_read";
    }


}
