package com.board.mssql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("userDto")
@NoArgsConstructor
public class UserDto {

    private Long userId;
    private String account;
    private String password;
}
