package com.kakao.kakaopay.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandling {

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ErrorMessage> applicationException(Exception ex) {
        log.error("{}", ex);
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
