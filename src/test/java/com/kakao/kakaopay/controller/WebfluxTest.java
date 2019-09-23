package com.kakao.kakaopay.controller;


import com.kakao.kakaopay.InitDataTest;
import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.DeivceResult;
import com.kakao.kakaopay.model.Device;
import com.kakao.kakaopay.repository.BankingMapper;
import com.kakao.kakaopay.service.impl.BankingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebFluxTest
@Slf4j
public class WebfluxTest {

    @Autowired
    private WebTestClient webClient;

    @SpyBean
    private BankingServiceImpl bankingService;

    @MockBean
    private BankingMapper bankingMapper;

    List<Device> devices; List<Banking> bankings;

    @PostConstruct
    public void init() throws IOException {
        bankings = InitDataTest.getBanking();
        devices = bankings.stream().map(b -> {return b.getDevice();}).distinct().collect(Collectors.toList());

        when(bankingMapper.getDeviceList()).thenReturn(devices);
        when(bankingMapper.getBankingList()).thenReturn(bankings);
    }

    @Test
    public void getDevices() throws Exception
    {
        EntityExchangeResult<DeivceResult> result = webClient.get().uri("/v1/bank/devices").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DeivceResult.class).returnResult();

        log.info(result.toString());
    }

    @Test
    public void getMaxUsageBankings() throws Exception
    {
        EntityExchangeResult<DeivceResult> result = webClient.get().uri("/v1/bank/maxUsageBankings").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DeivceResult.class).returnResult();

        log.info(result.toString());
    }

    @Test
    public void getYearMaxUsageBanking() throws Exception
    {
        EntityExchangeResult<DeivceResult> result = webClient.get().uri("/v1/bank/yearMaxUsageBanking/{year}", "2011").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DeivceResult.class).returnResult();

        log.info(result.toString());
    }

    @Test
    public void getDeviceMaxUsageBanking() throws Exception
    {
        Device device = devices.stream().filter(d -> d.getDevice_name().equals("스마트폰")).findAny().get();

        EntityExchangeResult<DeivceResult> result = webClient.get().uri("/v1/bank/deviceMaxUsageBanking/{device_id}", device.getDevice_id()).accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DeivceResult.class).returnResult();

        log.info(result.toString());

    }


}
