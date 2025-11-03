package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.records.MetricPointDTO;
import com.example.ISPStatDisplay.repositories.SpeedtestDataRepository;
import com.example.ISPStatDisplay.utilities.Utilities;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class MetricPointService {

    private final SpeedtestDataRepository repo;

    public MetricPointService(SpeedtestDataRepository repo){
        this.repo = repo;
    }

    public List<MetricPointDTO> getAll(String metric) {
        return switch (metric) {
            case "downloadBandwidth" -> Utilities.truncateBandwidthValue(this.repo.getAllDownloadBandwidths());
            case "uploadBandwidth" -> Utilities.truncateBandwidthValue(this.repo.getAllUploadBandwidths());
            case "downloadPingLatency" -> this.repo.getAllDownloadPingLatencies();
            case "uploadPingLatency" -> this.repo.getAllUploadPingLatencies();
            case "idlePingLatency" -> this.repo.getAllIdlePingLatencies();
            case "downloadPingHigh" -> this.repo.getAllDownloadPingHighs();
            case "uploadPingHigh" -> this.repo.getAllUploadPingHighs();
            case "idlePingHigh" -> this.repo.getAllIdlePingHighs();
            case "downloadPingLow" -> this.repo.getAllDownloadPingLows();
            case "uploadPingLow" -> this.repo.getAllUploadPingLows();
            case "idlePingLow" -> this.repo.getAllIdlePingLows();
            case "downloadPingJitter" -> this.repo.getAllDownloadPingJitters();
            case "uploadPingJitter" -> this.repo.getAllUploadPingJitters();
            case "idlePingJitter" -> this.repo.getAllIdlePingJitters();
            case "packetLoss" -> Utilities.truncatePacketLossValue(this.repo.getAllPacketLosses());
            default -> List.of();
        };
    }

    public List<MetricPointDTO> getMetricFromStartDateToNow(String metric, Instant startDate) {
        return switch (metric) {
            case "downloadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getDownloadBandwidthFromStartDateToNow(startDate));
            case "uploadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getUploadBandwidthFromStartDateToNow(startDate));
            case "downloadPingLatency" -> this.repo.getDownloadPingLatencyFromStartDateToNow(startDate);
            case "uploadPingLatency" -> this.repo.getUploadPingLatencyFromStartDateToNow(startDate);
            case "idlePingLatency" -> this.repo.getIdlePingLatencyFromStartDateToNow(startDate);
            case "downloadPingHigh" -> this.repo.getDownloadPingHighFromStartDateToNow(startDate);
            case "uploadPingHigh" -> this.repo.getUploadPingHighFromStartDateToNow(startDate);
            case "idlePingHigh" -> this.repo.getIdlePingHighFromStartDateToNow(startDate);
            case "downloadPingLow" -> this.repo.getDownloadPingLowFromStartDateToNow(startDate);
            case "uploadPingLow" -> this.repo.getUploadPingLowFromStartDateToNow(startDate);
            case "idlePingLow" -> this.repo.getIdlePingLowFromStartDateToNow(startDate);
            case "downloadPingJitter" -> this.repo.getDownloadPingJitterFromStartDateToNow(startDate);
            case "uploadPingJitter" -> this.repo.getUploadPingJitterFromStartDateToNow(startDate);
            case "idlePingJitter" -> this.repo.getIdlePingJitterFromStartDateToNow(startDate);
            case "packetLoss" -> Utilities.truncatePacketLossValue(this.repo.getPacketLossFromStartDateToNow(startDate));
            default -> List.of();
        };
    }

    public List<MetricPointDTO> getMetricOnDateRange(String metric, Instant startDate, Instant endDate) {
        return switch (metric) {
            case "downloadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getDownloadBandwidthOnDateRange(startDate, endDate));
            case "uploadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getUploadBandwidthOnDateRange(startDate, endDate));
            case "downloadPingLatency" -> this.repo.getDownloadPingLatencyOnDateRange(startDate, endDate);
            case "uploadPingLatency" -> this.repo.getUploadPingLatencyOnDateRange(startDate, endDate);
            case "idlePingLatency" -> this.repo.getIdlePingLatencyOnDateRange(startDate, endDate);
            case "downloadPingHigh" -> this.repo.getDownloadPingHighOnDateRange(startDate, endDate);
            case "uploadPingHigh" -> this.repo.getUploadPingHighOnDateRange(startDate, endDate);
            case "idlePingHigh" -> this.repo.getIdlePingHighOnDateRange(startDate, endDate);
            case "downloadPingLow" -> this.repo.getDownloadPingLowOnDateRange(startDate, endDate);
            case "uploadPingLow" -> this.repo.getUploadPingLowOnDateRange(startDate, endDate);
            case "idlePingLow" -> this.repo.getIdlePingLowOnDateRange(startDate, endDate);
            case "downloadPingJitter" -> this.repo.getDownloadPingJitterOnDateRange(startDate, endDate);
            case "uploadPingJitter" -> this.repo.getUploadPingJitterOnDateRange(startDate, endDate);
            case "idlePingJitter" -> this.repo.getIdlePingJitterOnDateRange(startDate, endDate);
            case "packetLoss" -> Utilities.truncatePacketLossValue(this.repo.getPacketLossOnDateRange(startDate, endDate));
            default -> List.of();
        };
    }
}
