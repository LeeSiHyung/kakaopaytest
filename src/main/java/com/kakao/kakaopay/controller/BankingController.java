package com.kakao.kakaopay.controller;

import com.kakao.kakaopay.model.BankingResult;
import com.kakao.kakaopay.model.DeivceResult;
import com.kakao.kakaopay.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bank")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    @GetMapping(value = "/devices")
    public DeivceResult getDevices() {
        return new DeivceResult(bankingService.getDevices());
    }

    @GetMapping(value = "/maxUsageBankings")
    public DeivceResult getMaxUsageBankings() {
        return new DeivceResult(bankingService.getMaxUsageBankings());
    }

    @GetMapping(value = "/yearMaxUsageBanking")
    public BankingResult getYearMaxUsageBanking(String year) {
        return new BankingResult(bankingService.getYearMaxUsageBanking(year));
    }

    @GetMapping(value = "/deviceMaxUsageBanking")
    public BankingResult getDeviceMaxUsageBanking(String device_id) {
        return new BankingResult(bankingService.getDeviceMaxUsageBanking(device_id));
    }
}
