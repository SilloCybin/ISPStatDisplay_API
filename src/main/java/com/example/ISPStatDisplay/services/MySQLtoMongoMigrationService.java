package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.entities.*;
import com.example.ISPStatDisplay.repositories.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySQLtoMongoMigrationService {

    private final MySQLToMongoMigrationAveragesRepository mySQLToMongoMigrationAveragesRepository;
    private final MySQLToMongoMigrationServerRepository mySQLToMongoMigrationServerRepository;
    private final MySQLToMongoMigrationSpeedtestDataRepository mySQLToMongoMigrationSpeedtestDataRepository;
    private final SpeedTestStatsRepository speedTestStatsRepository;
    private final AveragesRepository averagesRepository;
    private final ServerRepository serverRepository;

    public MySQLtoMongoMigrationService(MySQLToMongoMigrationAveragesRepository mySQLToMongoMigrationAveragesRepository,
                                        MySQLToMongoMigrationServerRepository mySQLToMongoMigrationServerRepository,
                                        MySQLToMongoMigrationSpeedtestDataRepository mySQLToMongoMigrationSpeedtestDataRepository,
                                        SpeedTestStatsRepository speedTestStatsRepository,
                                        AveragesRepository averagesRepository,
                                        ServerRepository serverRepository){

        this.mySQLToMongoMigrationAveragesRepository = mySQLToMongoMigrationAveragesRepository;
        this.mySQLToMongoMigrationServerRepository = mySQLToMongoMigrationServerRepository;
        this.mySQLToMongoMigrationSpeedtestDataRepository = mySQLToMongoMigrationSpeedtestDataRepository;
        this.speedTestStatsRepository = speedTestStatsRepository;
        this.averagesRepository = averagesRepository;
        this.serverRepository = serverRepository;
    }

    @Transactional(readOnly = true)
    public void migrateAllServers() {
        List<Server> allServers = this.serverRepository.findAll();
        List<ServerMongo> convertedServers = allServers.stream().map(this::mapServerToMongo).toList();
        this.mySQLToMongoMigrationServerRepository.saveAll(convertedServers);
        System.out.println("Migrated " + allServers.size() + " servers to FerretDB!");
    }

    private ServerMongo mapServerToMongo(Server server){
        ServerMongo serverMongo = new ServerMongo();
        serverMongo.setId(server.getServer_id());
        serverMongo.setServer_id(server.getServer_id());
        serverMongo.setHostname(server.getHostname());
        serverMongo.setPort(server.getPort());
        serverMongo.setProvider(server.getProvider());
        serverMongo.setLocation(server.getLocation());
        serverMongo.setCountry(server.getCountry());
        serverMongo.setIp(server.getIp());
        return serverMongo;
    }

    @Transactional(readOnly = true)
    public void migrateAllSpeedtestData() {
        List<SpeedtestData> allSpeedtestData = this.speedTestStatsRepository.findAll();
        List<SpeedtestDataMongo> convertedSpeedtestData = allSpeedtestData.stream().map(this::mapSpeedtestDataToMongo).toList();
        this.mySQLToMongoMigrationSpeedtestDataRepository.saveAll(convertedSpeedtestData);
        System.out.println("Migrated " + allSpeedtestData.size() + " SpeedtestData to FerretDB!");
    }

    private SpeedtestDataMongo mapSpeedtestDataToMongo(SpeedtestData speedtestData){
        SpeedtestDataMongo speedtestDataMongo = new SpeedtestDataMongo();

        IdlePingMongo idlePingMongo = new IdlePingMongo();
        idlePingMongo.setHigh(speedtestData.getIdlePing().getHigh());
        idlePingMongo.setLow(speedtestData.getIdlePing().getLow());
        idlePingMongo.setJitter(speedtestData.getIdlePing().getJitter());
        idlePingMongo.setLatency(speedtestData.getIdlePing().getLatency());
        DownloadTestMongo downloadTestMongo = getDownloadTestMongo(speedtestData);
        UploadTestMongo uploadTestMongo = getUploadTestMongo(speedtestData);
        speedtestDataMongo.setId(speedtestData.getId());
        speedtestDataMongo.setTimestamp(speedtestData.getTimestamp());
        speedtestDataMongo.setIdlePingMongo(idlePingMongo);
        speedtestDataMongo.setDownloadTestMongo(downloadTestMongo);
        speedtestDataMongo.setUploadTestMongo(uploadTestMongo);
        speedtestDataMongo.setPacketLoss(speedtestData.getPacketLoss());
        speedtestDataMongo.setIsp(speedtestData.getIsp());
        speedtestDataMongo.setServerMongo(this.mySQLToMongoMigrationServerRepository.findById(speedtestData.getServer().getServer_id())
                        .orElseThrow(() -> new RuntimeException("ServerMongo not found for id " + speedtestData.getServer().getServer_id())));

        return speedtestDataMongo;
    }

    private static UploadTestMongo getUploadTestMongo(SpeedtestData speedtestData) {
        UploadPingMongo uploadPingMongo = new UploadPingMongo();
        uploadPingMongo.setHigh(speedtestData.getUploadTest().getUploadPing().getHigh());
        uploadPingMongo.setLow(speedtestData.getUploadTest().getUploadPing().getLow());
        uploadPingMongo.setJitter(speedtestData.getUploadTest().getUploadPing().getJitter());
        uploadPingMongo.setLatency(speedtestData.getUploadTest().getUploadPing().getLatency());
        UploadTestMongo uploadTestMongo = new UploadTestMongo();
        uploadTestMongo.setBandwidth(speedtestData.getUploadTest().getBandwidth());
        uploadTestMongo.setBytes(speedtestData.getUploadTest().getBytes());
        uploadTestMongo.setElapsed(speedtestData.getUploadTest().getElapsed());
        uploadTestMongo.setUploadPingMongo(uploadPingMongo);
        return uploadTestMongo;
    }

    private static DownloadTestMongo getDownloadTestMongo(SpeedtestData speedtestData) {
        DownloadPingMongo downloadPingMongo = new DownloadPingMongo();
        downloadPingMongo.setHigh(speedtestData.getDownloadTest().getDownloadPing().getHigh());
        downloadPingMongo.setLow(speedtestData.getDownloadTest().getDownloadPing().getLow());
        downloadPingMongo.setJitter(speedtestData.getDownloadTest().getDownloadPing().getJitter());
        downloadPingMongo.setLatency(speedtestData.getDownloadTest().getDownloadPing().getLatency());
        DownloadTestMongo downloadTestMongo = new DownloadTestMongo();
        downloadTestMongo.setBandwidth(speedtestData.getDownloadTest().getBandwidth());
        downloadTestMongo.setBytes(speedtestData.getDownloadTest().getBytes());
        downloadTestMongo.setElapsed(speedtestData.getDownloadTest().getElapsed());
        downloadTestMongo.setDownloadPingMongo(downloadPingMongo);
        return downloadTestMongo;
    }

    @Transactional(readOnly = true)
    public void migrateAverages() {
        Averages averages = this.averagesRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Averages not found"));
        this.mySQLToMongoMigrationAveragesRepository.save(averages);
        System.out.println("Migrated Averages to FerretDB!");
    }

}
