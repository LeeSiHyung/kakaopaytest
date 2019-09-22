package com.kakao.kakaopay.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@Slf4j
public class DeviceUtilTest {
    @Test
    public void createDeviceIdTest(){
        String deviceId = DeviceUtil.createDeviceId();
        log.info("DeviceUtilTest createDeviceIdTest device_id : " + deviceId);
        assertNotNull(deviceId);
    }
}
