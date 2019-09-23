package com.kakao.kakaopay.service.impl;

import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.Device;
import com.kakao.kakaopay.repository.BankingMapper;
import com.kakao.kakaopay.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    private BankingMapper bankingMapper;

    @Override
    public List<Device> getDevices() {
        return bankingMapper.getDeviceList();
    }

    @Override
    public List<Banking> getBankings() {
        return bankingMapper.getBankingList();
    }

    @Override
    public List<Banking> getMaxUsageBankings() {
        List<Banking> bankings = bankingMapper.getBankingList().stream()
                .collect(Collectors.groupingBy(Banking::getYear, Collectors.maxBy(Comparator.comparing(Banking::getRate))))
                .entrySet().stream()
                .map(c -> {return c.getValue().orElse(null);}).collect(Collectors.toList());
        return bankings;
    }

    @Override
    public Banking getYearMaxUsageBanking(String year) {
        Banking banking = bankingMapper.getBankingList().parallelStream()
                .filter(b -> b.getYear().equals(year))
                .max(Comparator.comparing(Banking::getRate)).orElse(null);
        return banking;
    }

    @Override
    public Banking getDeviceMaxUsageBanking(String device_id) {
        Banking banking = bankingMapper.getBankingList().parallelStream()
                .filter(b -> b.getDevice_id().equals(device_id))
                .max(Comparator.comparing(Banking::getRate)).orElse(null);
        return banking;
    }

    @Override
    public Banking getPredictMaxUsageBanking(String year) {
        return null;
    }
}
