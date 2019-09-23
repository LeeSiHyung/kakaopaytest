package com.kakao.kakaopay.interceptor;

import com.kakao.kakaopay.model.User;
import com.kakao.kakaopay.security.JwtUtil;
import com.kakao.kakaopay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String token = request.getHeader("Authorization");
        User user = jwtUtil.parseToken(token);

        // 권한 인증 체크
        if(!token.equals(userService.getToken(user))) new RuntimeException("토큰이 유요하지 않습니다.");
        return true;
    }

}
