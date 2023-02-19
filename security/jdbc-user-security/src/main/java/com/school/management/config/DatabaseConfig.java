package com.school.management.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

@Configuration
@PropertySource("classpath:jdbc_user_security.properties")
public class DatabaseConfig extends AbstractR2dbcConfiguration {

    @Value("${host.db.path}")
    private String path;

    @Value("${host.db.port}")
    private Integer port;

    @Value("${host.db.username}")
    private String userName;

    @Value("${host.db.password}")
    private String password;

    @Value("${host.db.schema}")
    private String schemaName;

    @Value("${host.db.name}")
    private String databaseName;

    @Override
    @Bean
    @NonNull
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host(path)
                .port(port)  // optional, defaults to 5432
                .username(userName)
                .password(password)
                .schema(schemaName)
                .database(databaseName)  // optional
                .build());
    }

}

