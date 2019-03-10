package com.dongkyoo.webe.configuration;

import oracle.jdbc.pool.OracleDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:properties/db.properties")
@MapperScan("com.dongkyoo.webe.mappers")
public class JDBCConfig {

    @Value("${url}")
    private String oracleUrl;

    @Value("${dbUserName}")
    private String dbUserName;

    @Value("${dbPassword}")
    private String dbUserPassword;


    @Bean
    public DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setDriverType("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        dataSource.setURL(oracleUrl);
        dataSource.setUser(dbUserName);
        dataSource.setPassword(dbUserPassword);

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setTypeAliasesPackage("com.dongkyoo.webe.datas");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/dongkyoo/webe/mappers/xmls/*.xml"));
        sqlSessionFactory.setConfiguration(getConfiguration());

        return sqlSessionFactory.getObject();
    }

    public org.apache.ibatis.session.Configuration getConfiguration() {
        org.apache.ibatis.session.Configuration c = new org.apache.ibatis.session.Configuration();
        c.setJdbcTypeForNull(JdbcType.VARCHAR);
        return c;
    }
}
