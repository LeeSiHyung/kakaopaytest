package com.kakao.kakaopay.repository;

import com.kakao.kakaopay.InitDataTest;
import com.kakao.kakaopay.config.DatabaseConfig;
import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.Device;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DatabaseConfig.class})
@Sql({"/schema.sql"})
public class BankingMapperTest{

    @Autowired
    BankingMapper bankingMapper;

    List<Device> devices; List<Banking> bankings;

    @PostConstruct
    public void init() throws IOException {
        bankings = InitDataTest.getBanking();
        devices = bankings.stream().map(b -> {return b.getDevice();}).distinct().collect(Collectors.toList());
    }

    @Test
    // @Transactional
    public void insertTest(){
        devices.stream().forEach(d -> {
            bankingMapper.insertDevice(d);
        });

        List<Device> deviceDBList = bankingMapper.getDeviceList();
        assertThat(deviceDBList.size(), is(devices.size()));

        bankings.stream().forEach(b -> {
            bankingMapper.insertBanking(b);
        });

        List<Banking> bankingDBList = bankingMapper.getBankingList();
        assertThat(bankingDBList.size(), is(bankings.size()));
    }



}
