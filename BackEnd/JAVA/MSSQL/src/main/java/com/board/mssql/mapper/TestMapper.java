package com.board.mssql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper {

    Long testProcedure();

    void insertAllInOne(@Param("account") String account,
                        @Param("password") String password,
                        @Param("board") String board,
                        @Param("title") String title,
                        @Param("content") String content);
}
