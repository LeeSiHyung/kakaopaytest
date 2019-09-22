package com.kakao.kakaopay;

import com.kakao.kakaopay.model.Banking;
import com.kakao.kakaopay.model.CsvMappingBanking;
import com.kakao.kakaopay.model.Device;
import com.kakao.kakaopay.utils.CsvUtil;
import com.kakao.kakaopay.utils.DeviceUtil;
import com.kakao.kakaopay.value.DeviceType;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Slf4j
public class InitDataTest {

    private final static String csvFilePath = "/data/2019년하반기_서버개발자_데이터.csv";

    @Test
    public void initDataTest() throws IOException{

        List<Banking> bankings = InitDataTest.getBanking();
        List<Device> devices = bankings.stream().map(b -> {return b.getDevice();}).distinct().collect(Collectors.toList());

        devices.forEach(d -> log.info(d.toString()));
        assertThat(devices.size(), is(5));

        bankings.forEach(b -> log.info(b.toString()));
        assertThat(bankings.size(), is(8 * devices.size()));
    }

    public static final List<Banking> getBanking() throws IOException {

        List<Device> devices = new ArrayList<>();
        for(DeviceType deviceType : DeviceType.values()){
            Device device = new Device(DeviceUtil.createDeviceId(), deviceType.getDescription());
            devices.add(device);
        }

        List<Banking> bankings = new ArrayList<>();
        List<CsvMappingBanking> csvMappingBankings = CsvUtil.read(CsvMappingBanking.class, new ClassPathResource(csvFilePath).getInputStream());
        csvMappingBankings.stream().forEach(b -> {
            for(DeviceType deviceType : DeviceType.values()){
                Device device = devices.stream()
                        .filter(d -> d.getDevice_name().equals(deviceType.getDescription()))
                        .findAny().get();
                bankings.add(b.getBanking(device));
            }
        });
        return bankings;
    }
}
