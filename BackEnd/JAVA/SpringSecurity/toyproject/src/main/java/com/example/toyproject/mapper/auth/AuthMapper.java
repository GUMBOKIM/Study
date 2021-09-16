package com.example.toyproject.mapper.auth;


import com.example.toyproject.dto.auth.AuthMapDto;
import com.example.toyproject.dto.auth.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AuthMapper {

    com.example.toyproject.security.model.UserModel findOneByUsername(@Param("account") String account);

    UserModel findOneByUserId(@Param("userNo") Long userNo);

    List<AuthMapDto> findGroupUrlMap();
}
