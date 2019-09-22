package com.kakao.kakaopay.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value="com.kakao.kakaopay.repository", sqlSessionFactoryRef="sqlSessionFactory")
public class DatabaseConfig {

    @Value("${spring.datasource.jdbcUrl}")
    private String clusterUrl;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(clusterUrl);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource datasource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(datasource);
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:/mappers/*.xml"));
        return sqlSessionFactory.getObject();
    }


}
