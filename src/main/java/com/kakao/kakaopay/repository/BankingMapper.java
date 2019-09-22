package com.kakao.kakaopay.repository;

import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.Device;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.*;

@Mapper
public interface BankingMapper {
    List<Device> getDeviceList();
    List<Banking> getBankingList();
    void insertDevice(Device device) throws DataAccessException;
    void insertBanking(Banking banking) throws DataAccessException;
}
