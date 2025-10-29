package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.repositories.SpeedTestStatsRepository;
import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.SpeedtestData;
import com.example.ISPStatDisplay.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpeedTestStatsService {

    @Autowired
    private SpeedTestStatsRepository repo;

    public Optional<SpeedtestData> getSpeedTestData(Long id) {
        return repo.findById(id);
    }

    public Long getIDOfLatest() {
        return repo.findLatestTest();
    }

    public List<MetricPoint> getAll(String metric) {
        switch (metric){
            case "downloadBandwidth":
                return Utilities.truncateBandwidthValue(repo.getAllDownloadBandwidths());
            case "uploadBandwidth":
                return Utilities.truncateBandwidthValue(repo.getAllUploadBandwidths());
            case "downloadPingLatency":
                return repo.getAllDownloadPingLatencies();
            case "uploadPingLatency":
                return repo.getAllUploadPingLatencies();
            case "idlePingLatency":
                return repo.getAllIdlePingLatencies();
            case "downloadPingHigh":
                return repo.getAllDownloadPingHighs();
            case "uploadPingHigh":
                return repo.getAllUploadPingHighs();
            case "idlePingHigh":
                return repo.getAllIdlePingHighs();
            case "downloadPingLow":
                return repo.getAllDownloadPingLows();
            case "uploadPingLow":
                return repo.getAllUploadPingLows();
            case "idlePingLow":
                return repo.getAllIdlePingLows();
            case "downloadPingJitter":
                return repo.getAllDownloadPingJitters();
            case "uploadPingJitter":
                return repo.getAllUploadPingJitters();
            case "idlePingJitter":
                return repo.getAllIdlePingJitters();
            case "packetLoss":
                return Utilities.truncatePacketLossValue(repo.getAllPacketLosses());
        }
        return List.of();
    }

    public List<MetricPoint> getMetricFromStartDateToNow(String metric, Date startDate) {
        switch (metric) {
            case "downloadBandwidth":
                return Utilities.truncateBandwidthValue(repo.getDownloadBandwidthFromStartDateToNow(startDate));
            case "uploadBandwidth":
                return Utilities.truncateBandwidthValue(repo.getUploadBandwidthFromStartDateToNow(startDate));
            case "downloadPingLatency":
                return repo.getDownloadPingLatencyFromStartDateToNow(startDate);
            case "uploadPingLatency":
                return repo.getUploadPingLatencyFromStartDateToNow(startDate);
            case "idlePingLatency":
                return repo.getIdlePingLatencyFromStartDateToNow(startDate);
            case "downloadPingHigh":
                return repo.getDownloadPingHighFromStartDateToNow(startDate);
            case "uploadPingHigh":
                return repo.getUploadPingHighFromStartDateToNow(startDate);
            case "idlePingHigh":
                return repo.getIdlePingHighFromStartDateToNow(startDate);
            case "downloadPingLow":
                return repo.getDownloadPingLowFromStartDateToNow(startDate);
            case "uploadPingLow":
                return repo.getUploadPingLowFromStartDateToNow(startDate);
            case "idlePingLow":
                return repo.getIdlePingLowFromStartDateToNow(startDate);
            case "downloadPingJitter":
                return repo.getDownloadPingJitterFromStartDateToNow(startDate);
            case "uploadPingJitter":
                return repo.getUploadPingJitterFromStartDateToNow(startDate);
            case "idlePingJitter":
                return repo.getIdlePingJitterFromStartDateToNow(startDate);
            case "packetLoss":
                return Utilities.truncatePacketLossValue(repo.getPacketLossFromStartDateToNow(startDate));
        }
        return List.of();
    }

    public List<MetricPoint> getMetricOnDateRange(String metric, Date startDate, Date endDate) {
        switch (metric) {
            case "downloadBandwidth":
                return Utilities.truncateBandwidthValue(repo.getDownloadBandwidthOnDateRange(startDate, endDate));
            case "uploadBandwidth":
                return Utilities.truncateBandwidthValue(repo.getUploadBandwidthOnDateRange(startDate, endDate));
            case "downloadPingLatency":
                return repo.getDownloadPingLatencyOnDateRange(startDate, endDate);
            case "uploadPingLatency":
                return repo.getUploadPingLatencyOnDateRange(startDate, endDate);
            case "idlePingLatency":
                return repo.getIdlePingLatencyOnDateRange(startDate, endDate);
            case "downloadPingHigh":
                return repo.getDownloadPingHighOnDateRange(startDate, endDate);
            case "uploadPingHigh":
                return repo.getUploadPingHighOnDateRange(startDate, endDate);
            case "idlePingHigh":
                return repo.getIdlePingHighOnDateRange(startDate, endDate);
            case "downloadPingLow":
                return repo.getDownloadPingLowOnDateRange(startDate, endDate);
            case "uploadPingLow":
                return repo.getUploadPingLowOnDateRange(startDate, endDate);
            case "idlePingLow":
                return repo.getIdlePingLowOnDateRange(startDate, endDate);
            case "downloadPingJitter":
                return repo.getDownloadPingJitterOnDateRange(startDate, endDate);
            case "uploadPingJitter":
                return repo.getUploadPingJitterOnDateRange(startDate, endDate);
            case "idlePingJitter":
                return repo.getIdlePingJitterOnDateRange(startDate, endDate);
            case "packetLoss":
                return Utilities.truncatePacketLossValue(repo.getPacketLossOnDateRange(startDate, endDate));
        }
        return List.of();
    }
}
