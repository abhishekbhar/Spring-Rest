package com.abhibhr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistanceConfiguration {
    @Autowired Environment env;

    @Bean
    public DataSource dataSource(){
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverClassName"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));


//        HARDCODED VALUES REPLACED WITH VALUES FROM properties file
//        dataSource.setDriverClassName("org.sqlite.JDBC");
//        dataSource.setUrl("jdbc:sqlite:memory:myDb?cache=shared");
//        dataSource.setUsername("test");
//        dataSource.setPassword("");


        return dataSource;
    }
}
