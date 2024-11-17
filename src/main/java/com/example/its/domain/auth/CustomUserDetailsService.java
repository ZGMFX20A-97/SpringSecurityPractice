package com.example.its.domain.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.findByUsername(username)
                .map(user->new CustomUserDetails(user.getUsername(),
                        user.getPassword(),
                        toGrantedAuthorityList(user.getAuthority())))
                .orElseThrow(()->new UsernameNotFoundException("Given username is not Found.(username='"+username+")"));

    }

    private List<GrantedAuthority> toGrantedAuthorityList(String authority) {
        return Collections.singletonList(new SimpleGrantedAuthority(authority));
    }
}
