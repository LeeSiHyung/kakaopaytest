package com.kakao.kakaopay.service;

import com.kakao.kakaopay.model.User;

public interface UserService {
    String getToken(User user);
    String refresh(String token);
}
