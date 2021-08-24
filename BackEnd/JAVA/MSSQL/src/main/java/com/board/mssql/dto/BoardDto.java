package com.board.mssql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("boardDto")
@NoArgsConstructor
public class BoardDto {

    private Long boardId;
    private String boardName;
}
