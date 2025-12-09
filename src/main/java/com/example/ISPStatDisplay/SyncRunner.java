package com.example.ISPStatDisplay;

import com.example.ISPStatDisplay.services.sync.SyncService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SyncRunner implements CommandLineRunner {

    private final SyncService syncService;

    public SyncRunner(SyncService syncService) {
        this.syncService = syncService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initial sync at startup: " + LocalTime.now());
        syncService.syncServers();
        syncService.syncSpeedtestData();
        syncService.syncAverages();
        syncService.syncStandardDeviations();
    }

    @Scheduled(cron = "0 1 * * * *")
    public void scheduledDatabaseSync() throws Exception {
        System.out.println("Batch of " + LocalTime.now());
        syncService.syncServers();
        syncService.syncSpeedtestData();
        syncService.syncAverages();
        syncService.syncStandardDeviations();
    }
}