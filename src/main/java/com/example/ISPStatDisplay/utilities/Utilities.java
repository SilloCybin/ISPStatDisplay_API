package com.example.ISPStatDisplay.utilities;

import com.example.ISPStatDisplay.models.MetricPoint;

import java.util.List;

public class Utilities {

    public static List<MetricPoint> truncateBandwidthValue(List<MetricPoint> list) {
        for (MetricPoint toModify : list) {
            Float uglyBandwidth = toModify.getValue().floatValue();
            Float rounded = (float) Math.round(uglyBandwidth * 8 / 1000000 * 100) / 100;
            toModify.setValue(rounded);
        }
        return list;
    }

    public static List<MetricPoint> truncatePacketLossValue(List<MetricPoint> list) {
        for (MetricPoint toModify : list) {
            Float uglyBandwidth = toModify.getValue().floatValue();
            Float rounded = (float) Math.round(uglyBandwidth * 100) / 100;
            toModify.setValue(rounded);
        }
        return list;
    }

}
