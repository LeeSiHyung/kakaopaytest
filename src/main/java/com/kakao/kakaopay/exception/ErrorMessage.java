package com.kakao.kakaopay.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorMessage {
    private int errorCode;
    private String message;
    ErrorMessage(HttpStatus errorCode, String message){
        this.errorCode = errorCode.value();
        this.message = message;
    }
}
