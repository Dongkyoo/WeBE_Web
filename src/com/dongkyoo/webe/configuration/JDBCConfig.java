package com.dongkyoo.webe.configuration;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:properties/db.properties")
public class JDBCConfig {

    @Value("${url}")
    private String oracleUrl;

    @Value("${username}")
    private String dbUserName;

    @Value("${password}")
    private String dbUserPassword;


    @Bean
    public DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL(oracleUrl);
        dataSource.setUser(dbUserName);
        dataSource.setPassword(dbUserPassword);

        return dataSource;
    }
}
