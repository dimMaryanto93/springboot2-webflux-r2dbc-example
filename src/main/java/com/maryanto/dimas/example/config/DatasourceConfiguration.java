package com.maryanto.dimas.example.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
@FlywayDataSource
public class DatasourceConfiguration extends AbstractR2dbcConfiguration {

    @Value("${database.host}")
    String host;
    @Value("${database.port}")
    Integer port;
    @Value("${database.name}")
    String databaseName;
    @Value("${database.auth.username}")
    String username;
    @Value("${database.auth.password}")
    String password;

    @Bean
    public DatabaseClient databaseClient(@Qualifier("connectionFactory") ConnectionFactory cf) {
        return DatabaseClient.create(cf);
    }

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
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
}
