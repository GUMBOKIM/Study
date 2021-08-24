package com.board.mssql.mapper;

import com.board.mssql.dto.ArticleDto;
import com.board.mssql.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    Long createArticle(ArticleDto articleDto);
    Long updateArticle(ArticleDto articleDto);
    Long findArticle(ArticleDto articleDto);
    void deleteArticle(ArticleDto articleDto);

    List<ArticleDto> findArticleList();
}
