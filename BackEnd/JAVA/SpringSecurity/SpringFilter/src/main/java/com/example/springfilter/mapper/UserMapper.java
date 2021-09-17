package com.example.springfilter.mapper;


import com.example.springfilter.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDto findOneByUsername(@Param("account") String account);
}
