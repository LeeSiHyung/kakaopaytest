package com.kakao.kakaopay.service;

import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.Device;

import java.util.*;

public interface BankingService {
    List<Device> getDevices();
    List<Banking> getBankings();
    List<Banking> getMaxUsageBankings();
    Banking getYearMaxUsageBanking(String year);
    Banking getDeviceMaxUsageBanking(String device_id);
    Banking getPredictMaxUsageBanking(String year);
}
