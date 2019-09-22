package com.kakao.kakaopay.utils;


import com.kakao.kakaopay.model.CsvMappingBanking;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@Slf4j
public class CsvUtilTest {

    String csvFilePath = "/data/2019년하반기_서버개발자_데이터.csv";

    @Test
    public void readTest() throws IOException {
        List<CsvMappingBanking> banking = CsvUtil.read(CsvMappingBanking.class, new ClassPathResource(csvFilePath).getInputStream());
        banking.stream().forEach(b -> log.info(b.toString()));
        assertThat(banking.size(), is(8));
    }
}
