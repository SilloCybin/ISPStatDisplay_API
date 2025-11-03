package com.example.ISPStatDisplay;

import com.example.ISPStatDisplay.services.sync.SyncService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncRunner implements CommandLineRunner {

    private final SyncService syncService;

    public SyncRunner(SyncService syncService) {
        this.syncService = syncService;
    }

    @Override
    public void run(String... args) throws Exception {

        syncService.syncServers();
        syncService.syncSpeedtestData();
        syncService.syncAverages();
    }

    @Scheduled(cron = "0 1 * * * *")
    public void scheduledDatabaseSync() throws Exception {

        syncService.syncServers();
        syncService.syncSpeedtestData();
        syncService.syncAverages();
    }
}