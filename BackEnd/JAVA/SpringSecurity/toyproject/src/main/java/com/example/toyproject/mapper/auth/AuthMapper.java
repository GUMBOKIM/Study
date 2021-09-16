package com.example.toyproject.mapper.auth;


import com.example.toyproject.dto.auth.AuthMapDto;
import com.example.toyproject.dto.auth.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthMapper {

    UserDto findOneByUsername(@Param("account") String account);

    UserDto findOneByUserId(@Param("userNo") Long userNo);

    List<AuthMapDto> findGroupUrlMap();
}
