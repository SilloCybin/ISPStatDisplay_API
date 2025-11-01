package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.records.MetricPointDTO;
import com.example.ISPStatDisplay.repositories.SpeedTestStatsRepository;
import com.example.ISPStatDisplay.utilities.Utilities;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class MetricPointService {

    private final SpeedTestStatsRepository repo;

    public MetricPointService(SpeedTestStatsRepository repo){
        this.repo = repo;
    }

    public List<MetricPointDTO> getAll(String metric) {
        return switch (metric) {
            case "downloadBandwidth" -> Utilities.truncateBandwidthValue(repo.getAllDownloadBandwidths());
            case "uploadBandwidth" -> Utilities.truncateBandwidthValue(repo.getAllUploadBandwidths());
            case "downloadPingLatency" -> repo.getAllDownloadPingLatencies();
            case "uploadPingLatency" -> repo.getAllUploadPingLatencies();
            case "idlePingLatency" -> repo.getAllIdlePingLatencies();
            case "downloadPingHigh" -> repo.getAllDownloadPingHighs();
            case "uploadPingHigh" -> repo.getAllUploadPingHighs();
            case "idlePingHigh" -> repo.getAllIdlePingHighs();
            case "downloadPingLow" -> repo.getAllDownloadPingLows();
            case "uploadPingLow" -> repo.getAllUploadPingLows();
            case "idlePingLow" -> repo.getAllIdlePingLows();
            case "downloadPingJitter" -> repo.getAllDownloadPingJitters();
            case "uploadPingJitter" -> repo.getAllUploadPingJitters();
            case "idlePingJitter" -> repo.getAllIdlePingJitters();
            case "packetLoss" -> Utilities.truncatePacketLossValue(repo.getAllPacketLosses());
            default -> List.of();
        };
    }

    public List<MetricPointDTO> getMetricFromStartDateToNow(String metric, Instant startDate) {
        return switch (metric) {
            case "downloadBandwidth" ->
                    Utilities.truncateBandwidthValue(repo.getDownloadBandwidthFromStartDateToNow(startDate));
            case "uploadBandwidth" ->
                    Utilities.truncateBandwidthValue(repo.getUploadBandwidthFromStartDateToNow(startDate));
            case "downloadPingLatency" -> repo.getDownloadPingLatencyFromStartDateToNow(startDate);
            case "uploadPingLatency" -> repo.getUploadPingLatencyFromStartDateToNow(startDate);
            case "idlePingLatency" -> repo.getIdlePingLatencyFromStartDateToNow(startDate);
            case "downloadPingHigh" -> repo.getDownloadPingHighFromStartDateToNow(startDate);
            case "uploadPingHigh" -> repo.getUploadPingHighFromStartDateToNow(startDate);
            case "idlePingHigh" -> repo.getIdlePingHighFromStartDateToNow(startDate);
            case "downloadPingLow" -> repo.getDownloadPingLowFromStartDateToNow(startDate);
            case "uploadPingLow" -> repo.getUploadPingLowFromStartDateToNow(startDate);
            case "idlePingLow" -> repo.getIdlePingLowFromStartDateToNow(startDate);
            case "downloadPingJitter" -> repo.getDownloadPingJitterFromStartDateToNow(startDate);
            case "uploadPingJitter" -> repo.getUploadPingJitterFromStartDateToNow(startDate);
            case "idlePingJitter" -> repo.getIdlePingJitterFromStartDateToNow(startDate);
            case "packetLoss" -> Utilities.truncatePacketLossValue(repo.getPacketLossFromStartDateToNow(startDate));
            default -> List.of();
        };
    }

    public List<MetricPointDTO> getMetricOnDateRange(String metric, Instant startDate, Instant endDate) {
        return switch (metric) {
            case "downloadBandwidth" ->
                    Utilities.truncateBandwidthValue(repo.getDownloadBandwidthOnDateRange(startDate, endDate));
            case "uploadBandwidth" ->
                    Utilities.truncateBandwidthValue(repo.getUploadBandwidthOnDateRange(startDate, endDate));
            case "downloadPingLatency" -> repo.getDownloadPingLatencyOnDateRange(startDate, endDate);
            case "uploadPingLatency" -> repo.getUploadPingLatencyOnDateRange(startDate, endDate);
            case "idlePingLatency" -> repo.getIdlePingLatencyOnDateRange(startDate, endDate);
            case "downloadPingHigh" -> repo.getDownloadPingHighOnDateRange(startDate, endDate);
            case "uploadPingHigh" -> repo.getUploadPingHighOnDateRange(startDate, endDate);
            case "idlePingHigh" -> repo.getIdlePingHighOnDateRange(startDate, endDate);
            case "downloadPingLow" -> repo.getDownloadPingLowOnDateRange(startDate, endDate);
            case "uploadPingLow" -> repo.getUploadPingLowOnDateRange(startDate, endDate);
            case "idlePingLow" -> repo.getIdlePingLowOnDateRange(startDate, endDate);
            case "downloadPingJitter" -> repo.getDownloadPingJitterOnDateRange(startDate, endDate);
            case "uploadPingJitter" -> repo.getUploadPingJitterOnDateRange(startDate, endDate);
            case "idlePingJitter" -> repo.getIdlePingJitterOnDateRange(startDate, endDate);
            case "packetLoss" -> Utilities.truncatePacketLossValue(repo.getPacketLossOnDateRange(startDate, endDate));
            default -> List.of();
        };
    }
}
