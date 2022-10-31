package com.school.management.student.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseMigrationStrategy implements FlywayMigrationStrategy {
    @Override
    public void migrate(Flyway flyway) {
            flyway.repair();
            flyway.migrate();
    }
}
