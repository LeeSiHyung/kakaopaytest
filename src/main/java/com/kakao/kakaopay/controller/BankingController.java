package com.kakao.kakaopay.controller;

import com.kakao.kakaopay.model.BankingResult;
import com.kakao.kakaopay.model.DeivceResult;
import com.kakao.kakaopay.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/bank")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    @GetMapping(value = "/devices")
    public Mono<DeivceResult> getDevices() {
        return Mono.just(new DeivceResult(bankingService.getDevices()));
    }

    @GetMapping(value = "/maxUsageBankings")
    public Mono<DeivceResult> getMaxUsageBankings() {
        return Mono.just(new DeivceResult(bankingService.getMaxUsageBankings()));
    }

    @GetMapping(value = "/yearMaxUsageBanking/{year}")
    public Mono<BankingResult> getYearMaxUsageBanking(@PathVariable("year") String year) {
        return Mono.just(new BankingResult(bankingService.getYearMaxUsageBanking(year)));
    }

    @GetMapping(value = "/deviceMaxUsageBanking/{device_id}")
    public Mono<BankingResult> getDeviceMaxUsageBanking(@PathVariable("device_id") String device_id) {
        return Mono.just(new BankingResult(bankingService.getDeviceMaxUsageBanking(device_id)));
    }
}
