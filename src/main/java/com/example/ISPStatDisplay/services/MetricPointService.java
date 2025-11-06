package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.MetricPointDTO;
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
            case "downloadPingLatency" -> Utilities.truncateValue(this.repo.getAllDownloadPingLatencies());
            case "uploadPingLatency" -> Utilities.truncateValue(this.repo.getAllUploadPingLatencies());
            case "idlePingLatency" -> Utilities.truncateValue(this.repo.getAllIdlePingLatencies());
            case "downloadPingHigh" -> Utilities.truncateValue(this.repo.getAllDownloadPingHighs());
            case "uploadPingHigh" -> Utilities.truncateValue(this.repo.getAllUploadPingHighs());
            case "idlePingHigh" -> Utilities.truncateValue(this.repo.getAllIdlePingHighs());
            case "downloadPingLow" -> Utilities.truncateValue(this.repo.getAllDownloadPingLows());
            case "uploadPingLow" -> Utilities.truncateValue(this.repo.getAllUploadPingLows());
            case "idlePingLow" -> Utilities.truncateValue(this.repo.getAllIdlePingLows());
            case "downloadPingJitter" -> Utilities.truncateValue(this.repo.getAllDownloadPingJitters());
            case "uploadPingJitter" -> Utilities.truncateValue(this.repo.getAllUploadPingJitters());
            case "idlePingJitter" -> Utilities.truncateValue(this.repo.getAllIdlePingJitters());
            case "packetLoss" -> Utilities.truncateValue(this.repo.getAllPacketLosses());
            default -> List.of();
        };
    }

    public List<MetricPointDTO> getMetricFromStartDateToNow(String metric, Instant startDate) {
        return switch (metric) {
            case "downloadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getDownloadBandwidthFromStartDateToNow(startDate));
            case "uploadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getUploadBandwidthFromStartDateToNow(startDate));
            case "downloadPingLatency" -> Utilities.truncateValue(this.repo.getDownloadPingLatencyFromStartDateToNow(startDate));
            case "uploadPingLatency" -> Utilities.truncateValue(this.repo.getUploadPingLatencyFromStartDateToNow(startDate));
            case "idlePingLatency" -> Utilities.truncateValue(this.repo.getIdlePingLatencyFromStartDateToNow(startDate));
            case "downloadPingHigh" -> Utilities.truncateValue(this.repo.getDownloadPingHighFromStartDateToNow(startDate));
            case "uploadPingHigh" -> Utilities.truncateValue(this.repo.getUploadPingHighFromStartDateToNow(startDate));
            case "idlePingHigh" -> Utilities.truncateValue(this.repo.getIdlePingHighFromStartDateToNow(startDate));
            case "downloadPingLow" -> Utilities.truncateValue(this.repo.getDownloadPingLowFromStartDateToNow(startDate));
            case "uploadPingLow" -> Utilities.truncateValue(this.repo.getUploadPingLowFromStartDateToNow(startDate));
            case "idlePingLow" -> Utilities.truncateValue(this.repo.getIdlePingLowFromStartDateToNow(startDate));
            case "downloadPingJitter" -> Utilities.truncateValue(this.repo.getDownloadPingJitterFromStartDateToNow(startDate));
            case "uploadPingJitter" -> Utilities.truncateValue(this.repo.getUploadPingJitterFromStartDateToNow(startDate));
            case "idlePingJitter" -> Utilities.truncateValue(this.repo.getIdlePingJitterFromStartDateToNow(startDate));
            case "packetLoss" -> Utilities.truncateValue(this.repo.getPacketLossFromStartDateToNow(startDate));
            default -> List.of();
        };
    }

    public List<MetricPointDTO> getMetricOnDateRange(String metric, Instant startDate, Instant endDate) {
        return switch (metric) {
            case "downloadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getDownloadBandwidthOnDateRange(startDate, endDate));
            case "uploadBandwidth" ->
                    Utilities.truncateBandwidthValue(this.repo.getUploadBandwidthOnDateRange(startDate, endDate));
            case "downloadPingLatency" -> Utilities.truncateValue(this.repo.getDownloadPingLatencyOnDateRange(startDate, endDate));
            case "uploadPingLatency" -> Utilities.truncateValue(this.repo.getUploadPingLatencyOnDateRange(startDate, endDate));
            case "idlePingLatency" -> Utilities.truncateValue(this.repo.getIdlePingLatencyOnDateRange(startDate, endDate));
            case "downloadPingHigh" -> Utilities.truncateValue(this.repo.getDownloadPingHighOnDateRange(startDate, endDate));
            case "uploadPingHigh" -> Utilities.truncateValue(this.repo.getUploadPingHighOnDateRange(startDate, endDate));
            case "idlePingHigh" -> Utilities.truncateValue(this.repo.getIdlePingHighOnDateRange(startDate, endDate));
            case "downloadPingLow" -> Utilities.truncateValue(this.repo.getDownloadPingLowOnDateRange(startDate, endDate));
            case "uploadPingLow" -> Utilities.truncateValue(this.repo.getUploadPingLowOnDateRange(startDate, endDate));
            case "idlePingLow" -> Utilities.truncateValue(this.repo.getIdlePingLowOnDateRange(startDate, endDate));
            case "downloadPingJitter" -> Utilities.truncateValue(this.repo.getDownloadPingJitterOnDateRange(startDate, endDate));
            case "uploadPingJitter" -> Utilities.truncateValue(this.repo.getUploadPingJitterOnDateRange(startDate, endDate));
            case "idlePingJitter" -> Utilities.truncateValue(this.repo.getIdlePingJitterOnDateRange(startDate, endDate));
            case "packetLoss" -> Utilities.truncateValue(this.repo.getPacketLossOnDateRange(startDate, endDate));
            default -> List.of();
        };
    }
}
