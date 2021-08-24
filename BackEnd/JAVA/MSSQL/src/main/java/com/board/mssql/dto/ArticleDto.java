package com.board.mssql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("articleDto")
@NoArgsConstructor
public class ArticleDto {

    private Long articleId;
    private Long userId;
    private Long boardId;
    private String title;
    private String content;
}
