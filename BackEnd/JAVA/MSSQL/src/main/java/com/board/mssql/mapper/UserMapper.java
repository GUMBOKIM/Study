package com.board.mssql.mapper;

import com.board.mssql.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Long createUser(UserDto userDto);
    Long updateUser(UserDto userDto);
    Long findUser(UserDto userDto);
    void deleteUser(UserDto userDto);

}
