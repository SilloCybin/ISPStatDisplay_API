package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.Averages;
import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.SpeedtestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpeedTestStatsRepository extends JpaRepository<SpeedtestData, Integer> {

    Optional<SpeedtestData> findById(Long id);

    @Query("SELECT MAX(s.id) FROM SpeedtestData s")
    Long findLatestTest();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.bandwidth) FROM SpeedtestData s")
    List<MetricPoint> getAllDownloadBandwidths();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s")
    List<MetricPoint> getAllUploadBandwidths();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s")
    List<MetricPoint> getAllDownloadPingLatencies();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s")
    List<MetricPoint> getAllUploadPingLatencies();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.latency) FROM SpeedtestData s")
    List<MetricPoint> getAllIdlePingLatencies();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s")
    List<MetricPoint> getAllDownloadPingLows();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s")
    List<MetricPoint> getAllUploadPingLows();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.low) FROM SpeedtestData s")
    List<MetricPoint> getAllIdlePingLows();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s")
    List<MetricPoint> getAllDownloadPingHighs();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s")
    List<MetricPoint> getAllUploadPingHighs();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.high) FROM SpeedtestData s")
    List<MetricPoint> getAllIdlePingHighs();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s")
    List<MetricPoint> getAllDownloadPingJitters();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s")
    List<MetricPoint> getAllUploadPingJitters();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s")
    List<MetricPoint> getAllIdlePingJitters();

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s")
    List<MetricPoint> getAllPacketLoss();

}
