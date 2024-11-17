package com.example.its.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

   @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> findAll() {
        return userMapper.findAll();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    public void create(String username, String password,String authority) {

        userMapper.insert(username, passwordEncoder.encode(password),authority);
    }

}
