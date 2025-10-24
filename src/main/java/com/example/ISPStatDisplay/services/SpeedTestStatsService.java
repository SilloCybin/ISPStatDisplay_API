package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.repositories.SpeedTestStatsRepository;
import com.example.ISPStatDisplay.models.Averages;
import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.SpeedtestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpeedTestStatsService {

    @Autowired
    private SpeedTestStatsRepository repo;

    public Optional<SpeedtestData> getSpeedTestData(Long id){
        return repo.findById(id);
    }

    public Long getIDOfLatest() {
        return repo.findLatestTest();
    }

    public List<MetricPoint> getAllDownloadBandwidths(){
        return repo.getAllDownloadBandwidths();
    }

    public List<MetricPoint> getAllUploadBandwidths(){
        return repo.getAllUploadBandwidths();
    }

    public List<MetricPoint> getAllDownloadPingLatencies(){
        return repo.getAllDownloadPingLatencies();
    }

    public List<MetricPoint> getAllUploadPingLatencies(){
        return repo.getAllUploadPingLatencies();
    }

    public List<MetricPoint> getAllIdlePingLatencies(){
        return repo.getAllIdlePingLatencies();
    }

    public List<MetricPoint> getAllDownloadPingLows(){
        return repo.getAllDownloadPingLows();
    }

    public List<MetricPoint> getAllUploadPingLows(){
        return repo.getAllUploadPingLows();
    }

    public List<MetricPoint> getAllIdlePingLows(){
        return repo.getAllIdlePingLows();
    }

    public List<MetricPoint> getAllDownloadPingHighs(){
        return repo.getAllDownloadPingHighs();
    }

    public List<MetricPoint> getAllUploadPingHighs(){
        return repo.getAllUploadPingHighs();
    }

    public List<MetricPoint> getAllIdlePingHighs(){
        return repo.getAllIdlePingHighs();
    }

    public List<MetricPoint> getAllDownloadPingJitters(){
        return repo.getAllDownloadPingJitters();
    }

    public List<MetricPoint> getAllUploadPingJitters(){
        return repo.getAllUploadPingJitters();
    }

    public List<MetricPoint> getAllIdlePingJitters(){
        return repo.getAllIdlePingJitters();
    }

    public List<MetricPoint> getAllPacketLoss(){
        return repo.getAllPacketLoss();
    }

}
