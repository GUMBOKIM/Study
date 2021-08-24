package com.board.mssql.mapper;

import com.board.mssql.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    Long createUser(UserDto userDto);
    void updateUser(UserDto userDto);

    void deleteUser(@Param("userId") Long userId);


    Long loginUser(UserDto userDto);
    UserDto findUserByAccount(@Param("account") String account);
    UserDto findUserByUserId(@Param("account") Long userId);
}
