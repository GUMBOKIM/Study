package com.board.mssql.mapper;

import com.board.mssql.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    void createBoard(@Param("name") String name);
    void updateBoard(BoardDto boardDto);
    BoardDto findBoard(@Param("boardId") Long boardId);
    void deleteBoard(@Param("boardId") Long boardId);

    List<BoardDto> findBoardList();
}
