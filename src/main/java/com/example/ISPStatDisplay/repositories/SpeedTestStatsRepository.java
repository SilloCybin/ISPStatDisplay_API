package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.SpeedtestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SpeedTestStatsRepository extends JpaRepository<SpeedtestData, Integer> {

    Optional<SpeedtestData> findById(Long id);

    @Query("SELECT MAX(s.id) FROM SpeedtestData s")
    Long findLatestTest();

    /*
    Get entire history queries
    */
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
    List<MetricPoint> getAllPacketLosses();

    /*
    From start date queries
    */
    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getDownloadBandwidthFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getUploadBandwidthFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getDownloadPingLatencyFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getUploadPingLatencyFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getIdlePingLatencyFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getDownloadPingHighFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getUploadPingHighFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getIdlePingHighFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getDownloadPingLowFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getUploadPingLowFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getIdlePingLowFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getDownloadPingJitterFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getUploadPingJitterFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getIdlePingJitterFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getPacketLossFromStartDateToNow(Date startDate);

    /*
    On date range queries
    */
    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getDownloadBandwidthOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getUploadBandwidthOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getDownloadPingLatencyOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getUploadPingLatencyOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getIdlePingLatencyOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getDownloadPingLowOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getUploadPingLowOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getIdlePingLowOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getDownloadPingHighOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getUploadPingHighOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getIdlePingHighOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getDownloadPingJitterOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getUploadPingJitterOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getIdlePingJitterOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getPacketLossOnDateRange(Date startDate, Date endDate);

}
