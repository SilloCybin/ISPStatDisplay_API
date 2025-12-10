package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.CoordinateDTO;
import com.example.ISPStatDisplay.repositories.SpeedtestDataRepository;
import com.example.ISPStatDisplay.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoordinatesService {

    private final SpeedtestDataRepository repo;

    /*
    Metric series handlers
     */

    public List<CoordinateDTO> getAll(String metric) {
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

    public List<CoordinateDTO> getMetricFromStartDateToNow(String metric, Instant startDate) {
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

    public List<CoordinateDTO> getMetricOnDateRange(String metric, Instant startDate, Instant endDate) {
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


    /*
    Trendline handlers
     */

    public List<CoordinateDTO> getEntireTrendline(String metric, String trendline, Double parameter) {
        return switch (metric) {
            case "downloadBandwidth" -> Utilities.getTrendline(this.repo.getAllDownloadBandwidths(), trendline, metric, parameter);
            case "uploadBandwidth" -> Utilities.getTrendline(this.repo.getAllUploadBandwidths(), trendline, metric, parameter);
            case "downloadPingLatency" -> Utilities.getTrendline(this.repo.getAllDownloadPingLatencies(), trendline, metric, parameter);
            case "uploadPingLatency" -> Utilities.getTrendline(this.repo.getAllUploadPingLatencies(), trendline, metric, parameter);
            case "idlePingLatency" -> Utilities.getTrendline(this.repo.getAllIdlePingLatencies(), trendline, metric, parameter);
            case "downloadPingHigh" -> Utilities.getTrendline(this.repo.getAllDownloadPingHighs(), trendline, metric, parameter);
            case "uploadPingHigh" -> Utilities.getTrendline(this.repo.getAllUploadPingHighs(), trendline, metric, parameter);
            case "idlePingHigh" -> Utilities.getTrendline(this.repo.getAllIdlePingHighs(), trendline, metric, parameter);
            case "downloadPingLow" -> Utilities.getTrendline(this.repo.getAllDownloadPingLows(), trendline, metric, parameter);
            case "uploadPingLow" -> Utilities.getTrendline(this.repo.getAllUploadPingLows(), trendline, metric, parameter);
            case "idlePingLow" -> Utilities.getTrendline(this.repo.getAllIdlePingLows(), trendline, metric, parameter);
            case "downloadPingJitter" -> Utilities.getTrendline(this.repo.getAllDownloadPingJitters(), trendline, metric, parameter);
            case "uploadPingJitter" -> Utilities.getTrendline(this.repo.getAllUploadPingJitters(), trendline, metric, parameter);
            case "idlePingJitter" -> Utilities.getTrendline(this.repo.getAllIdlePingJitters(), trendline, metric, parameter);
            case "packetLoss" -> Utilities.getTrendline(this.repo.getAllPacketLosses(), trendline, metric, parameter);
            default -> List.of();
        };
    }

    public List<CoordinateDTO> getTrendlineFromStartDateToNow(String metric, String trendline, Instant startDate, Double parameter) {
        return switch (metric) {
            case "downloadBandwidth" -> Utilities.getTrendline(this.repo.getDownloadBandwidthFromStartDateToNow(startDate), trendline, metric, parameter);
            case "uploadBandwidth" -> Utilities.getTrendline(this.repo.getUploadBandwidthFromStartDateToNow(startDate), trendline, metric, parameter);
            case "downloadPingLatency" -> Utilities.getTrendline(this.repo.getDownloadPingLatencyFromStartDateToNow(startDate), trendline, metric, parameter);
            case "uploadPingLatency" -> Utilities.getTrendline(this.repo.getUploadPingLatencyFromStartDateToNow(startDate), trendline, metric, parameter);
            case "idlePingLatency" -> Utilities.getTrendline(this.repo.getIdlePingLatencyFromStartDateToNow(startDate), trendline, metric, parameter);
            case "downloadPingHigh" -> Utilities.getTrendline(this.repo.getDownloadPingHighFromStartDateToNow(startDate), trendline, metric, parameter);
            case "uploadPingHigh" -> Utilities.getTrendline(this.repo.getUploadPingHighFromStartDateToNow(startDate), trendline, metric, parameter);
            case "idlePingHigh" -> Utilities.getTrendline(this.repo.getIdlePingHighFromStartDateToNow(startDate), trendline, metric, parameter);
            case "downloadPingLow" -> Utilities.getTrendline(this.repo.getDownloadPingLowFromStartDateToNow(startDate), trendline, metric, parameter);
            case "uploadPingLow" -> Utilities.getTrendline(this.repo.getUploadPingLowFromStartDateToNow(startDate), trendline, metric, parameter);
            case "idlePingLow" -> Utilities.getTrendline(this.repo.getIdlePingLowFromStartDateToNow(startDate), trendline, metric, parameter);
            case "downloadPingJitter" -> Utilities.getTrendline(this.repo.getDownloadPingJitterFromStartDateToNow(startDate), trendline, metric, parameter);
            case "uploadPingJitter" -> Utilities.getTrendline(this.repo.getUploadPingJitterFromStartDateToNow(startDate), trendline, metric, parameter);
            case "idlePingJitter" -> Utilities.getTrendline(this.repo.getIdlePingJitterFromStartDateToNow(startDate), trendline, metric, parameter);
            case "packetLoss" -> Utilities.getTrendline(this.repo.getPacketLossFromStartDateToNow(startDate), trendline, metric, parameter);
            default -> List.of();
        };
    }

    public List<CoordinateDTO> getTrendlineOnDateRange(String metric, String trendline, Instant startDate, Instant endDate, Double parameter) {
        return switch (metric) {
            case "downloadBandwidth" -> Utilities.getTrendline(this.repo.getDownloadBandwidthOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "uploadBandwidth" -> Utilities.getTrendline(this.repo.getUploadBandwidthOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "downloadPingLatency" -> Utilities.getTrendline(this.repo.getDownloadPingLatencyOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "uploadPingLatency" -> Utilities.getTrendline(this.repo.getUploadPingLatencyOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "idlePingLatency" -> Utilities.getTrendline(this.repo.getIdlePingLatencyOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "downloadPingHigh" -> Utilities.getTrendline(this.repo.getDownloadPingHighOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "uploadPingHigh" -> Utilities.getTrendline(this.repo.getUploadPingHighOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "idlePingHigh" -> Utilities.getTrendline(this.repo.getIdlePingHighOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "downloadPingLow" -> Utilities.getTrendline(this.repo.getDownloadPingLowOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "uploadPingLow" -> Utilities.getTrendline(this.repo.getUploadPingLowOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "idlePingLow" -> Utilities.getTrendline(this.repo.getIdlePingLowOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "downloadPingJitter" -> Utilities.getTrendline(this.repo.getDownloadPingJitterOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "uploadPingJitter" -> Utilities.getTrendline(this.repo.getUploadPingJitterOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "idlePingJitter" -> Utilities.getTrendline(this.repo.getIdlePingJitterOnDateRange(startDate, endDate), trendline, metric, parameter);
            case "packetLoss" -> Utilities.getTrendline(this.repo.getPacketLossOnDateRange(startDate, endDate), trendline, metric, parameter);
            default -> List.of();
        };
    }
}
