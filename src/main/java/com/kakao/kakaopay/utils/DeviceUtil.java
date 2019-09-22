package com.kakao.kakaopay.utils;

import java.util.UUID;

public class DeviceUtil {
    public static String createDeviceId(){
        return UUID.randomUUID().toString();
    }
}
