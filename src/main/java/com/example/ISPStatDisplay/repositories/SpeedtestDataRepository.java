package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.documents.SpeedtestData;
import com.example.ISPStatDisplay.models.records.MetricPointDTO;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface SpeedtestDataRepository extends MongoRepository<SpeedtestData, Long> {

    Optional<SpeedtestData> findTopByOrderByIdDesc();

    /*
     * MetricPoint queries (MetricPoint not an entity, fields are extracted from SpeedtestDataMongo entities)
     */

        /*
        * Get entire history queries
        */

    @Aggregation(pipeline = {"{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.bandwidth' } }"})
    List<MetricPoint> getAllDownloadBandwidths();

    @Aggregation(pipeline = {"{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.bandwidth' } }"})
    List<MetricPoint> getAllUploadBandwidths();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.latency' } }"
    })
    List<MetricPointDTO> getAllDownloadPingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<MetricPointDTO> getAllUploadPingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<MetricPointDTO> getAllIdlePingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<MetricPointDTO> getAllDownloadPingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<MetricPointDTO> getAllUploadPingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<MetricPointDTO> getAllIdlePingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<MetricPointDTO> getAllDownloadPingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<MetricPointDTO> getAllUploadPingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })
    List<MetricPointDTO> getAllIdlePingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<MetricPointDTO> getAllDownloadPingJitters();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<MetricPointDTO> getAllUploadPingJitters();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<MetricPointDTO> getAllIdlePingJitters();

    @Aggregation(pipeline = {"{ $project: { _id: 0, timestamp: 1, uploadBandwidth: '$uploadTest.packetLoss' } }"})
    List<MetricPoint> getAllPacketLosses();

        /*
        * From start date queries
        */

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.bandwidth' } }"
    })
    List<MetricPoint> getDownloadBandwidthFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.bandwidth' } }"
    })
    List<MetricPoint> getUploadBandwidthFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.latency' } }"
    })     List<MetricPointDTO> getDownloadPingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })     List<MetricPointDTO> getUploadPingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })     List<MetricPointDTO> getIdlePingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })     List<MetricPointDTO> getDownloadPingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })     List<MetricPointDTO> getUploadPingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })     List<MetricPointDTO> getIdlePingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })     List<MetricPointDTO> getDownloadPingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })     List<MetricPointDTO> getUploadPingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })     List<MetricPointDTO> getIdlePingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })     List<MetricPointDTO> getDownloadPingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })     List<MetricPointDTO> getUploadPingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })     List<MetricPointDTO> getIdlePingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"
    })     List<MetricPoint> getPacketLossFromStartDateToNow(Instant startDate);

        /*
        * On date range queries
        */

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.bandwidth' } }"
    })
    List<MetricPoint> getDownloadBandwidthOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$UploadTest.bandwidth' } }"
    })
    List<MetricPoint> getUploadBandwidthOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.latency' } }"
    })
    List<MetricPointDTO> getDownloadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<MetricPointDTO> getUploadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<MetricPointDTO> getIdlePingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<MetricPointDTO> getDownloadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<MetricPointDTO> getUploadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<MetricPointDTO> getIdlePingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<MetricPointDTO> getDownloadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<MetricPointDTO> getUploadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<MetricPointDTO> getIdlePingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<MetricPointDTO> getDownloadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<MetricPointDTO> getUploadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<MetricPointDTO> getIdlePingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"
    })
    List<MetricPoint> getPacketLossOnDateRange(Instant startDate, Instant endDate);
}
