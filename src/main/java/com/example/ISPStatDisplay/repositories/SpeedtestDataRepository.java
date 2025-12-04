package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.beans.Coordinate;
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
     * Coordinate queries (Coordinate not an entity, fields are extracted from SpeedtestDataMongo entities)
     */

        /*
        * Get entire history queries
        */

    @Aggregation(pipeline = {"{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.bandwidth' } }"})
    List<Coordinate> getAllDownloadBandwidths();

    @Aggregation(pipeline = {"{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.bandwidth' } }"})
    List<Coordinate> getAllUploadBandwidths();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.latency' } }"
    })
    List<Coordinate> getAllDownloadPingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<Coordinate> getAllUploadPingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<Coordinate> getAllIdlePingLatencies();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<Coordinate> getAllDownloadPingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<Coordinate> getAllUploadPingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<Coordinate> getAllIdlePingLows();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<Coordinate> getAllDownloadPingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<Coordinate> getAllUploadPingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })
    List<Coordinate> getAllIdlePingHighs();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<Coordinate> getAllDownloadPingJitters();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<Coordinate> getAllUploadPingJitters();

    @Aggregation(pipeline = {
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<Coordinate> getAllIdlePingJitters();

    @Aggregation(pipeline = {"{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"})
    List<Coordinate> getAllPacketLosses();

        /*
        * From start date queries
        */

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.bandwidth' } }"
    })
    List<Coordinate> getDownloadBandwidthFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.bandwidth' } }"
    })
    List<Coordinate> getUploadBandwidthFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.latency' } }"
    })
    List<Coordinate> getDownloadPingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<Coordinate> getUploadPingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<Coordinate> getIdlePingLatencyFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<Coordinate> getDownloadPingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<Coordinate> getUploadPingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })
    List<Coordinate> getIdlePingHighFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<Coordinate> getDownloadPingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<Coordinate> getUploadPingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<Coordinate> getIdlePingLowFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<Coordinate> getDownloadPingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<Coordinate> getUploadPingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<Coordinate> getIdlePingJitterFromStartDateToNow(Instant startDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"
    })
    List<Coordinate> getPacketLossFromStartDateToNow(Instant startDate);

        /*
        * On date range queries
        */

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.bandwidth' } }"
    })
    List<Coordinate> getDownloadBandwidthOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.bandwidth' } }"
    })
    List<Coordinate> getUploadBandwidthOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.latency' } }"
    })
    List<Coordinate> getDownloadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.latency' } }"
    })
    List<Coordinate> getUploadPingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.latency' } }"
    })
    List<Coordinate> getIdlePingLatencyOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.low' } }"
    })
    List<Coordinate> getDownloadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.low' } }"
    })
    List<Coordinate> getUploadPingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.low' } }"
    })
    List<Coordinate> getIdlePingLowOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.high' } }"
    })
    List<Coordinate> getDownloadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.high' } }"
    })
    List<Coordinate> getUploadPingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.high' } }"
    })
    List<Coordinate> getIdlePingHighOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$downloadTest.downloadPing.jitter' } }"
    })
    List<Coordinate> getDownloadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$uploadTest.uploadPing.jitter' } }"
    })
    List<Coordinate> getUploadPingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$idlePing.jitter' } }"
    })
    List<Coordinate> getIdlePingJitterOnDateRange(Instant startDate, Instant endDate);

    @Aggregation(pipeline = {
            "{ $match: { timestamp: { $gte: ?0, $lte: ?1 } } }",
            "{ $project: { _id: 0, timestamp: 1, value: '$packetLoss' } }"
    })
    List<Coordinate> getPacketLossOnDateRange(Instant startDate, Instant endDate);
}
