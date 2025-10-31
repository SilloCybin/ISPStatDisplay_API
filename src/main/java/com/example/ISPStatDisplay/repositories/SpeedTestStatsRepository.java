package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.entities.MetricPoint;
import com.example.ISPStatDisplay.models.entities.SpeedtestData;
import com.example.ISPStatDisplay.models.records.MetricPointDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
    List<MetricPoint> getDownloadBandwidthFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getUploadBandwidthFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingLatencyFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingLatencyFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingLatencyFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingHighFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingHighFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingHighFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingLowFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingLowFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingLowFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getDownloadPingJitterFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getUploadPingJitterFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPointDTO> getIdlePingJitterFromStartDateToNow(Date startDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s WHERE s.timestamp >= :startDate")
    List<MetricPoint> getPacketLossFromStartDateToNow(Date startDate);

        /*
        * On date range queries
        */

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.downloadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getDownloadBandwidthOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.uploadTest.bandwidth) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getUploadBandwidthOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingLatencyOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingLatencyOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.latency) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingLatencyOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingLowOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingLowOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.low) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingLowOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingHighOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingHighOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.high) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingHighOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.downloadTest.downloadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getDownloadPingJitterOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.uploadTest.uploadPing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getUploadPingJitterOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.records.MetricPointDTO(s.timestamp, s.idlePing.jitter) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPointDTO> getIdlePingJitterOnDateRange(Date startDate, Date endDate);

    @Query("SELECT new com.example.ISPStatDisplay.models.entities.MetricPoint(s.timestamp, s.packetLoss) FROM SpeedtestData s WHERE s.timestamp >= :startDate AND s.timestamp <= :endDate")
    List<MetricPoint> getPacketLossOnDateRange(Date startDate, Date endDate);

}
