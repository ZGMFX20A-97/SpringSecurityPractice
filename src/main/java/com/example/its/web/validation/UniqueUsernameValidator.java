package com.example.its.web.validation;

import com.example.its.domain.auth.UserMapper;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    private final UserMapper userMapper;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userMapper.findByUsername(s).isEmpty();
    }
}
