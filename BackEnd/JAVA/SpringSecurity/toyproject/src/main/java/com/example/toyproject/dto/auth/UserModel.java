package com.example.toyproject.dto.auth;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Alias("UserDto")
public class UserModel {

    private String account;
    private String password;
    private String userGroup;
    private String nickName;

}
