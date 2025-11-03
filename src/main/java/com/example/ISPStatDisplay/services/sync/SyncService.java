package com.example.ISPStatDisplay.services.sync;

import com.example.ISPStatDisplay.models.entities.JPA.Averages;
import com.example.ISPStatDisplay.models.entities.JPA.Server;
import com.example.ISPStatDisplay.models.entities.JPA.SpeedtestData;
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

    private Long idOfLastSpeedtestDataInserted = 400L;

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
    }

    @Transactional(readOnly = true)
    public void syncServers() {
        /* Reinsert entire list of servers every time : very few servers, new server extremely rare, no need to keep
            last inserted's id to add only last line */
        List<Server> allServers = this.serverJPARepository.findAll();
        List<ServerMongo> convertedServers = allServers.stream().map(this::mapServerToMongo).toList();
        this.serverMongoRepository.saveAll(convertedServers);
        System.out.println("Synced " + allServers.size() + " servers to MongoDB!");
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
    public void syncSpeedtestData() {
        List<SpeedtestData> allSpeedtestData = this.speedTestStatsJPARepository.findAllByIdGreaterThan(this.idOfLastSpeedtestDataInserted);
        List<SpeedtestDataMongo> convertedSpeedtestData = allSpeedtestData.stream().map(this::mapSpeedtestDataToMongo).toList();
        this.speedtestDataMongoRepository.saveAll(convertedSpeedtestData);
        System.out.println("Synchronized " + allSpeedtestData + " with MongoDB!");
        this.idOfLastSpeedtestDataInserted = this.speedTestStatsJPARepository.count();
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
        speedtestDataMongo.setServerMongo(this.serverMongoRepository.findById(speedtestData.getServer().getServer_id())
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
    public void syncAverages() {
        Averages averages = this.averagesJPARepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Averages not found"));
        AveragesMongo averagesMongo = new AveragesMongo();
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
        System.out.println("Synced Averages to MongoDB!");
    }

}
