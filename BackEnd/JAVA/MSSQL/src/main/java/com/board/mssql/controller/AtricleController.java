package com.board.mssql.controller;

import com.board.mssql.dto.ArticleDto;
import com.board.mssql.mapper.ArticleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "게시글 컨트롤러임")
@Controller
@RequiredArgsConstructor
public class AtricleController {

    ArticleMapper articleMapper;

    @GetMapping("article/list")
    public void getArticleList(){

    }

    // Hidden ->  안보이게 하기
    @ApiOperation(value = "글 가져오기", hidden = true)
    @GetMapping("article/{aticleId}")
    public void getArticle(@PathVariable("articleId") Long articleId) {

    }

    // value -> 주소 옆에 붙는 설명
    @ApiOperation(value = "글 작성", notes = "메뉴 아이템을 신규 저장한다.")
    @PostMapping("article/post")
    public void postArticle(@RequestBody ArticleDto articleDto){
        articleDto.toString();

        Long articleId = articleMapper.createArticle(articleDto);
        System.out.println("articleDto = " + articleDto);


    }

}
