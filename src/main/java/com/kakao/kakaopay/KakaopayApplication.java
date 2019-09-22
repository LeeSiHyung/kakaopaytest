package com.kakao.kakaopay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.jdbc.Sql;

@SpringBootApplication
@Sql({"/schema.sql","/data.sql"})
public class KakaopayApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaopayApplication.class, args);
    }

}
