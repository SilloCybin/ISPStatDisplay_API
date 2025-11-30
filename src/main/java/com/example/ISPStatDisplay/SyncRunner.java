package com.example.ISPStatDisplay;

import com.example.ISPStatDisplay.services.sync.SyncService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SyncRunner {

    private final SyncService syncService;

    public SyncRunner(SyncService syncService) {
        this.syncService = syncService;
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