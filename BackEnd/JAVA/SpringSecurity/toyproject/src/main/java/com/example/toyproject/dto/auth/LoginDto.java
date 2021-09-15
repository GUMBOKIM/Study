package com.example.toyproject.dto.auth;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Alias("LoginDto")
public class LoginDto {

    String account;
    String password;
}
