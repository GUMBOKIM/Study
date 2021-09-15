package com.example.toyproject.dto.auth;

import lombok.AllArgsConstructor;
import org.apache.ibatis.type.Alias;

@AllArgsConstructor
@Alias("authMapDto")
public class AuthMapDto {
    String userGroup;
    String url;
}
