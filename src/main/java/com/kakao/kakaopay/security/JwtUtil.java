package com.kakao.kakaopay.security;

import com.kakao.kakaopay.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JwtUtil {

    @Value("jwt.secret")
    private String secret;

    public String generateToken(User u) {
        Claims claims = Jwts.claims().setSubject(UUID.randomUUID().toString());
        claims.put("userId", u.getUserId());
        claims.put("userPasswd", u.getUserPasswd());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public User parseToken(String token){
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return new User((String) body.get("userId"), (String) body.get("userPasswd"));
    }

}

