package com.kakao.kakaopay.controller;

import com.kakao.kakaopay.model.User;
import com.kakao.kakaopay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public String signup(User user) {
        return userService.getToken(user);
    }

    @PostMapping(value = "/refresh")
    public String refresh(String token) {
        return userService.refresh(token);
    }

}
