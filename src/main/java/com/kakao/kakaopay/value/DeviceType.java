package com.kakao.kakaopay.value;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum DeviceType {
    SMARTPHONE("스마트폰"),
    DESKTOP("데스크탑 컴퓨터"),
    NOTEBOOK("노트북 컴퓨터"),
    ETC("기타"),
    SMARTPAD("스마트패드");
    String description;
    DeviceType(String description){
        this.description = description;
    }

}
