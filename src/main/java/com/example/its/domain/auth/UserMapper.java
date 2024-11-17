package com.example.its.domain.auth;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper  {

    @Select("select * from users where username=#{username}")
    Optional<User> findByUsername(String username);
    @Select("select * from users")
    List<User> findAll();
    @Insert("insert into users (username,password,authority) values (#{username},#{password},#{authority}")
    void insert(String username, String password,String authority);

}
