package com.example.springfilter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("UserDto")
public class UserDto {

    private String account;
    private String password;
    private String userGroup;
    private String nickName;

}
