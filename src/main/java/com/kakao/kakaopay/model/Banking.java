package com.kakao.kakaopay.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Banking {

    @NonNull
    private Device device;
    private String year;
    private Double rate;

    public String getDevice_id(){
        return device.getDevice_id();
    }
}
