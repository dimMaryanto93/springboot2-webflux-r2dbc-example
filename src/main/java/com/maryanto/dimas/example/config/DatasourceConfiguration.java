package com.maryanto.dimas.example.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

import java.sql.SQLException;

@Configuration
@FlywayDataSource
public class DatasourceConfiguration {

    @Bean
    @Primary
    public ConnectionFactory connectionFactory(
            @Value("${database.host}") String host,
            @Value("${database.port}") Integer port,
            @Value("${database.name}") String databaseName,
            @Value("${database.auth.username}") String username,
            @Value("${database.auth.password}") String password) throws SQLException {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(host)
                        .port(port)
                        .database(databaseName)
                        .username(username)
                        .password(password)
                        .build()
        );
    }

    @Bean
    public ReactiveTransactionManager transactionalOperator(ConnectionFactory cf) {
        return new R2dbcTransactionManager(cf);
    }

}
