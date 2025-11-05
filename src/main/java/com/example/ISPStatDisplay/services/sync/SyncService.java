package com.example.ISPStatDisplay.services.sync;

import com.example.ISPStatDisplay.models.entities.MongoDB.*;
import com.example.ISPStatDisplay.repositories.JPA.AveragesJPARepository;
import com.example.ISPStatDisplay.repositories.JPA.ServerJPARepository;
import com.example.ISPStatDisplay.repositories.JPA.SpeedTestStatsJPARepository;
import com.example.ISPStatDisplay.repositories.MongoDB.AveragesMongoRepository;
import com.example.ISPStatDisplay.repositories.MongoDB.ServerMongoRepository;
import com.example.ISPStatDisplay.repositories.MongoDB.SpeedtestDataMongoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyncService {

    private final AveragesMongoRepository averagesMongoRepository;
    private final ServerMongoRepository serverMongoRepository;
    private final SpeedtestDataMongoRepository speedtestDataMongoRepository;
    private final SpeedTestStatsJPARepository speedTestStatsJPARepository;
    private final AveragesJPARepository averagesJPARepository;
    private final ServerJPARepository serverJPARepository;

    private Long idOfLastSpeedtestDataInserted;

    public SyncService(AveragesMongoRepository averagesMongoRepository,
                       ServerMongoRepository serverMongoRepository,
                       SpeedtestDataMongoRepository speedtestDataMongoRepository,
                       SpeedTestStatsJPARepository speedTestStatsJPARepository,
                       AveragesJPARepository averagesJPARepository,
                       ServerJPARepository serverJPARepository){

        this.averagesMongoRepository = averagesMongoRepository;
        this.serverMongoRepository = serverMongoRepository;
        this.speedtestDataMongoRepository = speedtestDataMongoRepository;
        this.speedTestStatsJPARepository = speedTestStatsJPARepository;
        this.averagesJPARepository = averagesJPARepository;
        this.serverJPARepository = serverJPARepository;
        this.idOfLastSpeedtestDataInserted = this.speedTestStatsJPARepository.findHighestId();
    }

    @Transactional(readOnly = true)
    public void syncServers() {
        /* Reinsert entire list of servers every time : very few servers, new server extremely rare, no need to keep
            last inserted's id to add only last line */
        List<com.example.ISPStatDisplay.models.entities.JPA.Server> allServers = this.serverJPARepository.findAll();
        List<Server> convertedServers = allServers.stream().map(this::mapServerToMongo).toList();
        this.serverMongoRepository.saveAll(convertedServers);
        System.out.println("Synced Servers :" + allServers + " with MongoDB!");
    }

    private Server mapServerToMongo(com.example.ISPStatDisplay.models.entities.JPA.Server server){
        Server serverMongo = new Server();
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
    public void syncSpeedtestData() {
        List<com.example.ISPStatDisplay.models.entities.JPA.SpeedtestData> allSpeedtestData = this.speedTestStatsJPARepository.findAllByIdGreaterThan(this.idOfLastSpeedtestDataInserted);
        List<SpeedtestData> convertedSpeedtestData = allSpeedtestData.stream().map(this::mapSpeedtestDataToMongo).toList();
        this.speedtestDataMongoRepository.saveAll(convertedSpeedtestData);
        System.out.println("Synced SpeedtestData :" + allSpeedtestData + " with MongoDB!");
        this.idOfLastSpeedtestDataInserted = this.speedTestStatsJPARepository.findHighestId();
    }

    private SpeedtestData mapSpeedtestDataToMongo(com.example.ISPStatDisplay.models.entities.JPA.SpeedtestData speedtestData){
        SpeedtestData speedtestDataMongo = new SpeedtestData();

        IdlePing idlePing = new IdlePing();
        idlePing.setHigh(speedtestData.getIdlePing().getHigh());
        idlePing.setLow(speedtestData.getIdlePing().getLow());
        idlePing.setJitter(speedtestData.getIdlePing().getJitter());
        idlePing.setLatency(speedtestData.getIdlePing().getLatency());
        DownloadTest downloadTest = getDownloadTestMongo(speedtestData);
        UploadTest uploadTest = getUploadTestMongo(speedtestData);
        speedtestDataMongo.setId(speedtestData.getId());
        speedtestDataMongo.setTimestamp(speedtestData.getTimestamp());
        speedtestDataMongo.setIdlePingMongo(idlePing);
        speedtestDataMongo.setDownloadTest(downloadTest);
        speedtestDataMongo.setUploadTest(uploadTest);
        speedtestDataMongo.setPacketLoss(speedtestData.getPacketLoss());
        speedtestDataMongo.setIsp(speedtestData.getIsp());
        speedtestDataMongo.setServer(this.serverMongoRepository.findById(speedtestData.getServer().getServer_id())
                        .orElseThrow(() -> new RuntimeException("Server not found for id " + speedtestData.getServer().getServer_id())));

        return speedtestDataMongo;
    }

    private static UploadTest getUploadTestMongo(com.example.ISPStatDisplay.models.entities.JPA.SpeedtestData speedtestData) {
        UploadPing uploadPing = new UploadPing();
        uploadPing.setHigh(speedtestData.getUploadTest().getUploadPing().getHigh());
        uploadPing.setLow(speedtestData.getUploadTest().getUploadPing().getLow());
        uploadPing.setJitter(speedtestData.getUploadTest().getUploadPing().getJitter());
        uploadPing.setLatency(speedtestData.getUploadTest().getUploadPing().getLatency());
        UploadTest uploadTest = new UploadTest();
        uploadTest.setBandwidth(speedtestData.getUploadTest().getBandwidth());
        uploadTest.setBytes(speedtestData.getUploadTest().getBytes());
        uploadTest.setElapsed(speedtestData.getUploadTest().getElapsed());
        uploadTest.setUploadPing(uploadPing);
        return uploadTest;
    }

    private static DownloadTest getDownloadTestMongo(com.example.ISPStatDisplay.models.entities.JPA.SpeedtestData speedtestData) {
        DownloadPing downloadPing = new DownloadPing();
        downloadPing.setHigh(speedtestData.getDownloadTest().getDownloadPing().getHigh());
        downloadPing.setLow(speedtestData.getDownloadTest().getDownloadPing().getLow());
        downloadPing.setJitter(speedtestData.getDownloadTest().getDownloadPing().getJitter());
        downloadPing.setLatency(speedtestData.getDownloadTest().getDownloadPing().getLatency());
        DownloadTest downloadTest = new DownloadTest();
        downloadTest.setBandwidth(speedtestData.getDownloadTest().getBandwidth());
        downloadTest.setBytes(speedtestData.getDownloadTest().getBytes());
        downloadTest.setElapsed(speedtestData.getDownloadTest().getElapsed());
        downloadTest.setDownloadPing(downloadPing);
        return downloadTest;
    }

    @Transactional(readOnly = true)
    public void syncAverages() {
        com.example.ISPStatDisplay.models.entities.JPA.Averages averages = this.averagesJPARepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Averages not found"));
        Averages averagesMongo = new Averages();
        averagesMongo.setId(averages.getId());
        averagesMongo.setDownloadBandwidth(averages.getDownloadBandwidth());
        averagesMongo.setUploadBandwidth(averages.getUploadBandwidth());
        averagesMongo.setDownloadPingLatency(averages.getDownloadPingLatency());
        averagesMongo.setDownloadPingHigh(averages.getDownloadPingHigh());
        averagesMongo.setDownloadPingLow(averages.getDownloadPingLow());
        averagesMongo.setDownloadPingJitter(averages.getDownloadPingJitter());
        averagesMongo.setUploadPingLatency(averages.getUploadPingLatency());
        averagesMongo.setUploadPingHigh(averages.getUploadPingHigh());
        averagesMongo.setUploadPingLow(averages.getUploadPingLow());
        averagesMongo.setUploadPingJitter(averages.getUploadPingJitter());
        averagesMongo.setIdlePingLatency(averages.getIdlePingLatency());
        averagesMongo.setIdlePingHigh(averages.getIdlePingHigh());
        averagesMongo.setIdlePingLow(averages.getIdlePingLow());
        averagesMongo.setIdlePingJitter(averages.getIdlePingJitter());
        averagesMongo.setPacketLoss(averages.getPacketLoss());

        this.averagesMongoRepository.save(averagesMongo);
        System.out.println("Synced Averages: "+ averages +" with MongoDB!");
    }

}
