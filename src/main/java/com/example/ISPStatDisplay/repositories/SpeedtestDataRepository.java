package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.beans.MetricPoint;
import com.example.ISPStatDisplay.models.beans.documents.SpeedtestData;
        ;
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
    List<MetricPoint> getAllDownloadPingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<MetricPoint> getAllUploadPingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<MetricPoint> getAllIdlePingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<MetricPoint> getAllDownloadPingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<MetricPoint> getAllUploadPingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<MetricPoint> getAllIdlePingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<MetricPoint> getAllDownloadPingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<MetricPoint> getAllUploadPingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })
    List<MetricPoint> getAllIdlePingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<MetricPoint> getAllDownloadPingJitters();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<MetricPoint> getAllUploadPingJitters();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<MetricPoint> getAllIdlePingJitters();

    @Aggregation(pipeline = {"{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"})
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
    })
    List<MetricPoint> getDownloadPingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<MetricPoint> getUploadPingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<MetricPoint> getIdlePingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<MetricPoint> getDownloadPingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<MetricPoint> getUploadPingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })
    List<MetricPoint> getIdlePingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<MetricPoint> getDownloadPingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<MetricPoint> getUploadPingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<MetricPoint> getIdlePingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<MetricPoint> getDownloadPingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<MetricPoint> getUploadPingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<MetricPoint> getIdlePingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"
    })
    List<MetricPoint> getPacketLossFromStartDateToNow(Instant startDate);

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
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.bandwidth' } }"
    })
    List<MetricPoint> getUploadBandwidthOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.latency' } }"
    })
    List<MetricPoint> getDownloadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<MetricPoint> getUploadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<MetricPoint> getIdlePingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<MetricPoint> getDownloadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<MetricPoint> getUploadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<MetricPoint> getIdlePingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<MetricPoint> getDownloadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<MetricPoint> getUploadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })
    List<MetricPoint> getIdlePingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<MetricPoint> getDownloadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<MetricPoint> getUploadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<MetricPoint> getIdlePingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"
    })
    List<MetricPoint> getPacketLossOnDateRange(Instant startDate, Instant endDate);
}
