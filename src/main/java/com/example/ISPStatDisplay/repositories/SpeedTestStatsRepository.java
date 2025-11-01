package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.entities.MetricPoint;
import com.example.ISPStatDisplay.models.entities.SpeedtestData;
import com.example.ISPStatDisplay.models.records.MetricPointDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SpeedTestStatsRepository extends JpaRepository<SpeedtestData, Integer> {

    /*
    SpeedtestData queries
     */

    Optional<SpeedtestData> findTopByOrderByIdDesc();


    /*
    * MetricPoint queries (MetricPoint not an entity, therefore it can't have its own repo)
    */

        /*
        * Get entire history queries
        */

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.downloadTest.bandwidth) FROM SpeedtestData s")
    List<MetricPoint> getAllDownloadBandwidths();

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s")
    List<MetricPoint> getAllUploadBandwidths();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s")
    List<MetricPointDTO> getAllDownloadPingLatencies();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s")
    List<MetricPointDTO> getAllUploadPingLatencies();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.latency) FROM SpeedtestData s")
    List<MetricPointDTO> getAllIdlePingLatencies();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s")
    List<MetricPointDTO> getAllDownloadPingLows();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s")
    List<MetricPointDTO> getAllUploadPingLows();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.low) FROM SpeedtestData s")
    List<MetricPointDTO> getAllIdlePingLows();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s")
    List<MetricPointDTO> getAllDownloadPingHighs();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s")
    List<MetricPointDTO> getAllUploadPingHighs();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.high) FROM SpeedtestData s")
    List<MetricPointDTO> getAllIdlePingHighs();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s")
    List<MetricPointDTO> getAllDownloadPingJitters();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s")
    List<MetricPointDTO> getAllUploadPingJitters();

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s")
    List<MetricPointDTO> getAllIdlePingJitters();

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s")
    List<MetricPoint> getAllPacketLosses();

        /*
        * From start date queries
        */

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.downloadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getDownloadBandwidthFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getUploadBandwidthFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingLatencyFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingLatencyFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingLatencyFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingHighFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingHighFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingHighFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingLowFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingLowFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingLowFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingJitterFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingJitterFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingJitterFromStartDateToNow(Instant startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getPacketLossFromStartDateToNow(Instant startDate);

        /*
        * On date range queries
        */

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.downloadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getDownloadBandwidthOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getUploadBandwidthOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingLowOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingHighOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingJitterOnDateRange(Instant startDate, Instant endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getPacketLossOnDateRange(Instant startDate, Instant endDate);

}
