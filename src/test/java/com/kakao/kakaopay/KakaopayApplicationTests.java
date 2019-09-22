package com.kakao.kakaopay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KakaopayApplicationTests {


    @Test
    @Sql(scripts = {"/schema.sql"})
    public void getSchemaSql(){

    }

    @Test
    public void contextLoads() {
    }

}
