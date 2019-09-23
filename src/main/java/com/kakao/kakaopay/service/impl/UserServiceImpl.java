package com.kakao.kakaopay.service.impl;

import com.kakao.kakaopay.model.User;
import com.kakao.kakaopay.repository.UserMapper;
import com.kakao.kakaopay.security.JwtUtil;
import com.kakao.kakaopay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getToken(User user) {
        if(Objects.isNull(userMapper.getUser(user.getUserId()))){
            throw new RuntimeException("이미 존재하는 ID 입니다.");
        }

        String token = jwtUtil.generateToken(user);
        user.setUserToken(token);
        userMapper.insertUser(user);
        return token;
    }

    @Override
    public String refresh(String token) {
        User user = jwtUtil.parseToken(token);
        String newToken = jwtUtil.generateToken(user);
        user.setUserToken(newToken);
        userMapper.updateToken(user);
        return newToken;
    }
}
