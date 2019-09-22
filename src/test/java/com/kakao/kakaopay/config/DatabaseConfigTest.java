package com.kakao.kakaopay.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DatabaseConfig.class})
public class DatabaseConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void dataSourceBeanPresenceTest(){
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
    }

    @Test
    public void transcationManagerBeanPresenceTest(){
        PlatformTransactionManager transactionManager = applicationContext.getBean("transactionManager", PlatformTransactionManager.class);
        assertNotNull(transactionManager);
    }

    @Test
    public void sqlSessionFactoryBeanPresenceTest(){
        SqlSessionFactory sqlSessionFactory = applicationContext.getBean("sqlSessionFactory", SqlSessionFactory.class);
        assertNotNull(sqlSessionFactory);
    }

}
