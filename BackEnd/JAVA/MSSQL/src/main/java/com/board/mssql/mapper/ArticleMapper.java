package com.board.mssql.mapper;

import com.board.mssql.dto.ArticleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

    Long createArticle(ArticleDto articleDto);
    void updateArticle(ArticleDto articleDto);
    ArticleDto findArticle(ArticleDto articleDto);
    void deleteArticle(@Param("articleId") Long articleId);

    List<ArticleDto> findArticleList();
}
