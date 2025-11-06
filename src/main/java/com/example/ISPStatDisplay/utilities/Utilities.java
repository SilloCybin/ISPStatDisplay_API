package com.example.ISPStatDisplay.utilities;

import com.example.ISPStatDisplay.models.DTOs.*;
import com.example.ISPStatDisplay.models.beans.MetricPoint;
import com.example.ISPStatDisplay.models.beans.documents.SpeedtestData;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static List<MetricPointDTO> truncateBandwidthValue(List<MetricPoint> list) {
        ArrayList<MetricPointDTO> metricPointDTOList = new ArrayList<>();
        for (MetricPoint toModify : list) {
            Float uglyBandwidthValue = toModify.getValue().floatValue();
            Float rounded = (float) Math.round(uglyBandwidthValue * 8 / 1000000 * 100) / 100; // Truncation + B/s to Mb/s conversion
            MetricPointDTO metricPointDTO = new MetricPointDTO(toModify.getTimestamp(), rounded);
            metricPointDTOList.add(metricPointDTO);
        }
        return metricPointDTOList;
    }

    public static List<MetricPointDTO> truncateValue(List<MetricPoint> list) {
        ArrayList<MetricPointDTO> metricPointDTOList = new ArrayList<>();
        for (MetricPoint toModify : list) {
            Float uglyValue = toModify.getValue().floatValue();
            Float rounded = (float) Math.round(uglyValue * 100) / 100;
            MetricPointDTO metricPointDTO = new MetricPointDTO(toModify.getTimestamp(), rounded);
            metricPointDTOList.add(metricPointDTO);
        }
        return metricPointDTOList;
    }

    public static SpeedtestDataDTO speedtestBeanToDTOMapping(SpeedtestData s) {
        return new SpeedtestDataDTO(
                s.getTimestamp(),
                new IdlePingDTO(
                        s.getIdlePing().getJitter(),
                        s.getIdlePing().getLatency(),
                        s.getIdlePing().getLow(),
                        s.getIdlePing().getHigh()),
                new DownloadTestDTO(
                        s.getDownloadTest().getBandwidth(),
                        s.getDownloadTest().getBytes(),
                        s.getDownloadTest().getElapsed(),
                        new DownloadPingDTO(
                                s.getDownloadTest().getDownloadPing().getJitter(),
                                s.getDownloadTest().getDownloadPing().getLatency(),
                                s.getDownloadTest().getDownloadPing().getLow(),
                                s.getDownloadTest().getDownloadPing().getHigh())),
                new UploadTestDTO(
                        s.getUploadTest().getBandwidth(),
                        s.getUploadTest().getBytes(),
                        s.getUploadTest().getElapsed(),
                        new UploadPingDTO(
                                s.getUploadTest().getUploadPing().getJitter(),
                                s.getUploadTest().getUploadPing().getLatency(),
                                s.getUploadTest().getUploadPing().getLow(),
                                s.getUploadTest().getUploadPing().getHigh())),
                s.getPacketLoss(),
                s.getIsp(),
                new ServerDTO(
                        s.getServer().getServer_id(),
                        s.getServer().getHostname(),
                        s.getServer().getPort(),
                        s.getServer().getProvider(),
                        s.getServer().getLocation(),
                        s.getServer().getCountry(),
                        s.getServer().getIp()));
    }
}
