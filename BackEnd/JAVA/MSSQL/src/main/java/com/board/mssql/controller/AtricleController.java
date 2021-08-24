package com.board.mssql.controller;

import com.board.mssql.dto.ArticleDto;
import com.board.mssql.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AtricleController {

    ArticleMapper articleMapper;

    @GetMapping("article/list")
    public void getArticleList(){

    }

    @GetMapping("article/{aticleId}")
    public void getArticle(@PathVariable("articleId") Long articleId) {

    }

    @PostMapping("article/post")
    public void postArticle(@RequestBody ArticleDto articleDto){
        articleDto.toString();

        Long articleId = articleMapper.createArticle(articleDto);
        System.out.println("articleDto = " + articleDto);


    }

}
