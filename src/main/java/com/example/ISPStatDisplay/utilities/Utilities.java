package com.example.ISPStatDisplay.utilities;

import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.records.MetricPointDTO;

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

}
