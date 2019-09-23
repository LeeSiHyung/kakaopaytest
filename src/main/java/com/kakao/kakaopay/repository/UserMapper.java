package com.kakao.kakaopay.repository;

import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.Device;
import com.kakao.kakaopay.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(String userId);
    void insertUser(User user) throws DataAccessException;
    void updateToken(User user) throws DataAccessException;
}
