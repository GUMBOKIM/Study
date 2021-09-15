package com.example.toyproject.mapper.auth;


import com.example.toyproject.dto.auth.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface AuthMapper {

    UserDto findOneByUsername(@Param("account") String account);
}
