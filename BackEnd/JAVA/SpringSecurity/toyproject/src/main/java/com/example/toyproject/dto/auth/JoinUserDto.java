package com.example.toyproject.dto.auth;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias("JoinUser")
public class JoinUserDto {

    private String account;
    private String password;
    private String userGroup;
    private String nickName;

}

