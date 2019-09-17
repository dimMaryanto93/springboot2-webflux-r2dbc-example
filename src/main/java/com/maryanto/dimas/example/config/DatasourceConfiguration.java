package com.maryanto.dimas.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfiguration {

    @Bean
    public JdbcTemplate jdbcTemplate(
            @Qualifier("dataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate(
            @Qualifier("dataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

}
