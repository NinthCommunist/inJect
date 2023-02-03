package org.inject.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:properties/application.properties"})
public class DBConfig {
    @Value("${spring.datasource.url}")
    private String DBUrl;

    @Value("${spring.datasource.username}")
    private String DBUser;

    @Value("${spring.datasource.password}")
    private String DBPassword;

    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource(DBUrl, DBUser, DBPassword);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

}
