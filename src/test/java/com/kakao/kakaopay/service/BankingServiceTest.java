package com.kakao.kakaopay.service;

import com.kakao.kakaopay.InitDataTest;
import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.Device;
import com.kakao.kakaopay.repository.BankingMapper;
import com.kakao.kakaopay.service.impl.BankingServiceImpl;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@Slf4j
public class BankingServiceTest{

    @SpyBean
    BankingServiceImpl bankingService;

    @MockBean
    BankingMapper bankingMapper;

    List<Device> devices; List<Banking> bankings;

    @PostConstruct
    public void init() throws IOException{
        bankings = InitDataTest.getBanking();
        devices = bankings.stream().map(b -> {return b.getDevice();}).distinct().collect(Collectors.toList());
    }

    @Test
    public void getDevicesTest(){
        when(bankingMapper.getDeviceList()).thenReturn(devices);
        List<Device> devices = bankingService.getDevices();
        devices.stream().forEach(d -> log.info(d.toString()));
        assertThat(devices.size(), is(5));
    }

    @Test
    public void getBankingsTest() throws IOException {
        when(bankingMapper.getBankingList()).thenReturn(bankings);
        List<Banking> bankings = bankingService.getBankings();
        bankings.stream().forEach(b -> log.info(b.toString()));
        assertThat(bankings.size(), is(8 * 5));
    }

    @Test
    public void getMaxUsageBankingTest() throws IOException {
        when(bankingMapper.getBankingList()).thenReturn(bankings);
        List<Banking> bankings = bankingService.getMaxUsageBankings();
        bankings.stream().forEach(b -> {
            log.info(b.toString());
           switch (b.getYear()){
               case "2011" : assertThat(95.1, is(b.getRate())); break;
               case "2012" : assertThat(93.9, is(b.getRate())); break;
               case "2013" : assertThat(67.1, is(b.getRate())); break;
               case "2014" : assertThat(64.2, is(b.getRate())); break;
               case "2015" : assertThat(73.2, is(b.getRate())); break;
               case "2016" : assertThat(85.1, is(b.getRate())); break;
               case "2017" : assertThat(90.6, is(b.getRate())); break;
               case "2018" : assertThat(90.5, is(b.getRate())); break;
           }
        });
    }

    @Test
    public void getMaxUsageBankingYearTest() throws IOException {
        String searchYear = "2011";
        when(bankingMapper.getBankingList()).thenReturn(bankings);
        Banking banking = bankingService.getYearMaxUsageBanking(searchYear);
        log.info(banking.toString());
        assertThat(banking.getRate(), is(95.1));
    }

    @Test
    public void getDeviceMaxUsageBankingTest() throws IOException {
        Device device = devices.stream().filter(d -> d.getDevice_name().equals("스마트폰")).findAny().get();
        when(bankingMapper.getBankingList()).thenReturn(bankings);
        Banking banking = bankingService.getDeviceMaxUsageBanking(device.getDevice_id());
        log.info(banking.toString());
        assertThat(banking.getRate(), is(90.6));
    }
}
