package com.example.its.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class User  {

    private String username;
    private String password;
    private String authority;


}
