package com.kakao.kakaopay.controller;


import com.kakao.kakaopay.InitDataTest;
import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.Device;
import com.kakao.kakaopay.repository.BankingMapper;
import com.kakao.kakaopay.repository.UserMapper;
import com.kakao.kakaopay.security.JwtUtil;
import com.kakao.kakaopay.service.UserService;
import com.kakao.kakaopay.service.impl.BankingServiceImpl;
import com.kakao.kakaopay.service.impl.UserServiceImpl;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
@Transactional
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean
    private JwtUtil jwtUtil;

    @SpyBean
    private UserServiceImpl userService;

    @MockBean
    private UserMapper userMapper;


    @Test
    public void signup() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/v1/user/signup/")
                .param("userId", "test1")
                .param("userPasswd", "12345")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void refresh() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post("/v1/bank/refresh")
                .param("token", "")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }



}
