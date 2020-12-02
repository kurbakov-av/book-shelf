package com.example.bookshelf.config.flyway;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class FlywayConfig {

    @Value("${multitenant.system.schema:app}")
    private String systemSchema;

    @Value("${multitenant.system.location:db/migration}")
    private String location;

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .locations(location)
                .dataSource(dataSource)
                .schemas(systemSchema)
                .load();

        flyway.migrate();

        return flyway;
    }
}
