package com.example.ISPStatDisplay;

import com.example.ISPStatDisplay.services.MySQLtoMongoMigrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MigrationRunner implements CommandLineRunner {

    private final MySQLtoMongoMigrationService migrationService;

    public MigrationRunner(MySQLtoMongoMigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @Override
    public void run(String... args) throws Exception {

        migrationService.migrateAllServers();
        migrationService.migrateAllSpeedtestData();
        migrationService.migrateAverages();

    }
}