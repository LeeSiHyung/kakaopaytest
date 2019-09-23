package com.kakao.kakaopay.security;

import com.kakao.kakaopay.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JwtUtil.class})
@Slf4j
public class JwtUtilTest {

    @Autowired
    JwtUtil jwtUtil;


    private User user;
    private String jwtToken;

    @PostConstruct
    public void init(){
        this.user = new User("test","1234");
        this.jwtToken = jwtUtil.generateToken(user);
    }

    @Test
    public void generateTokenTest(){
        log.info(jwtToken);
        assertNotNull(jwtToken);
    }

    @Test
    public void parseTokenTest(){
        User chekUser = jwtUtil.parseToken(jwtToken);
        log.info(chekUser.toString());
        assertThat(chekUser.getUserId(), is(user.getUserId()));
        assertThat(chekUser.getUserPasswd(), is(user.getUserPasswd()));
    }
}
