package com.board.mssql.mapper;

import com.board.mssql.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    Long createBoard(BoardDto boardDto);
    Long updateBoard(BoardDto boardDto);
    Long findBoard(BoardDto boardDto);
    void deleteBoard(BoardDto boardDto);

    List<BoardDto> findBoardList();
}
