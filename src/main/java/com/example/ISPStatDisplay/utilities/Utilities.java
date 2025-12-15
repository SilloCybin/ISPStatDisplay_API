package com.example.ISPStatDisplay.utilities;

import com.example.ISPStatDisplay.models.DTOs.*;
import com.example.ISPStatDisplay.models.beans.Coordinate;
import com.example.ISPStatDisplay.models.beans.documents.SpeedtestData;
import org.ejml.simple.SimpleMatrix;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

public class Utilities {

    public static List<CoordinateDTO> truncateBandwidthValuesFromCoordinateList(List<Coordinate> list) {

        ArrayList<CoordinateDTO> coordinateDTOList = new ArrayList<>();

        for (Coordinate toModify : list) {
            Float uglyBandwidthValue = toModify.getValue().floatValue();
            Float rounded = truncateBandwidthValue(uglyBandwidthValue);
            CoordinateDTO coordinateDTO = new CoordinateDTO(toModify.getTimestamp(), rounded);
            coordinateDTOList.add(coordinateDTO);
        }

        return coordinateDTOList;
    }

    private static Float truncateBandwidthValue(Float uglyBandwidthValue) {
        return (float) Math.round(uglyBandwidthValue * 8 / 1000000 * 100) / 100;
    }


    public static List<CoordinateDTO> truncateValuesFromCoordinateList(List<Coordinate> list) {

        ArrayList<CoordinateDTO> coordinateDTOList = new ArrayList<>();

        for (Coordinate toModify : list) {
            Float uglyValue = toModify.getValue().floatValue();
            Float rounded = truncateValue(uglyValue);
            CoordinateDTO coordinateDTO = new CoordinateDTO(toModify.getTimestamp(), rounded);
            coordinateDTOList.add(coordinateDTO);
        }

        return coordinateDTOList;
    }

    public static Float truncateValue(Float uglyValue){
        return (float) Math.round(uglyValue * 100) / 100;
    }


    public static SpeedtestDataDTO speedtestEntityToDTOMapping(SpeedtestData speedtestData) {

        return new SpeedtestDataDTO(
                speedtestData.getTimestamp(),
                new IdlePingDTO(
                        speedtestData.getIdlePing().getJitter(),
                        speedtestData.getIdlePing().getLatency(),
                        speedtestData.getIdlePing().getLow(),
                        speedtestData.getIdlePing().getHigh()),
                new DownloadTestDTO(
                        speedtestData.getDownloadTest().getBandwidth(),
                        speedtestData.getDownloadTest().getBytes(),
                        speedtestData.getDownloadTest().getElapsed(),
                        new DownloadPingDTO(
                                speedtestData.getDownloadTest().getDownloadPing().getJitter(),
                                speedtestData.getDownloadTest().getDownloadPing().getLatency(),
                                speedtestData.getDownloadTest().getDownloadPing().getLow(),
                                speedtestData.getDownloadTest().getDownloadPing().getHigh())),
                new UploadTestDTO(
                        speedtestData.getUploadTest().getBandwidth(),
                        speedtestData.getUploadTest().getBytes(),
                        speedtestData.getUploadTest().getElapsed(),
                        new UploadPingDTO(
                                speedtestData.getUploadTest().getUploadPing().getJitter(),
                                speedtestData.getUploadTest().getUploadPing().getLatency(),
                                speedtestData.getUploadTest().getUploadPing().getLow(),
                                speedtestData.getUploadTest().getUploadPing().getHigh())),
                speedtestData.getPacketLoss(),
                speedtestData.getIsp(),
                new ServerDTO(
                        speedtestData.getServer().getServer_id(),
                        speedtestData.getServer().getHostname(),
                        speedtestData.getServer().getPort(),
                        speedtestData.getServer().getProvider(),
                        speedtestData.getServer().getLocation(),
                        speedtestData.getServer().getCountry(),
                        speedtestData.getServer().getIp()));
    }


    public static List<TimeslotAveragesDTO> seriesToTimeslotAverages(List<CoordinateDTO> series, String metric) {

        Map<Integer, Map<Integer, List<Double>>> timeslotAndValuesMap = new TreeMap<>();
        Map<Integer, Map<Integer, Float>> timeslotAndAverageMap = new TreeMap<>();
        List<TimeslotAveragesDTO> timeslotAveragesDTOList = new ArrayList<>();
        List<Float> averageContainer;
        double average;
        float truncatedAverage;

        for (CoordinateDTO coordinate : series) {
            int hourOfTheDay = coordinate.timestamp().atZone(ZoneId.systemDefault()).getHour();
            int dayOfTheWeek = coordinate.timestamp().atZone(ZoneId.systemDefault()).getDayOfWeek().getValue();
            double value = coordinate.value().doubleValue();

            timeslotAndValuesMap
                    .computeIfAbsent(hourOfTheDay, dotw -> new TreeMap<>())
                    .computeIfAbsent(dayOfTheWeek, hotd -> new ArrayList<>())
                    .add(value);
        }

        for (var hourOfTheDayValuesEntry : timeslotAndValuesMap.entrySet()) {
            int hourOfTheDayAverage = hourOfTheDayValuesEntry.getKey();
            timeslotAndAverageMap.putIfAbsent(hourOfTheDayAverage, new TreeMap<>());

            for (var dayOfTheWeekValuesEntry : hourOfTheDayValuesEntry.getValue().entrySet()) {
                int dayOfTheWeekAverage = dayOfTheWeekValuesEntry.getKey();
                List<Double> values = dayOfTheWeekValuesEntry.getValue();

                average = values.stream().mapToDouble(v -> v).average().orElse(Double.NaN);
                truncatedAverage = Utilities.truncateValue((float) average);

                timeslotAndAverageMap.get(hourOfTheDayAverage).putIfAbsent(dayOfTheWeekAverage, truncatedAverage);
            }
        }

        for (var hourOfTheDayAveragesEntry : timeslotAndAverageMap.entrySet()) {
            String hour = LocalTime.of(hourOfTheDayAveragesEntry.getKey(), 0).toString();
            averageContainer = new ArrayList<>();

            for (var dayOfTheWeekAveragesEntry : hourOfTheDayAveragesEntry.getValue().entrySet()) {
                averageContainer.add(dayOfTheWeekAveragesEntry.getValue());
            }

            timeslotAveragesDTOList.add(
                    new TimeslotAveragesDTO(
                            hour,
                            averageContainer.get(0),
                            averageContainer.get(1),
                            averageContainer.get(2),
                            averageContainer.get(3),
                            averageContainer.get(4),
                            averageContainer.get(5),
                            averageContainer.get(6))
            );
        }

        return timeslotAveragesDTOList;
    }


    public static List<CoordinateDTO> getTrendline(List<Coordinate> list, String trendline, String metric, Double parameter){

        List<Coordinate> preTrendlinePoints = new ArrayList<>();
        List<CoordinateDTO> trendlinePoints;

        if (trendline.equals("polynomialRegression")){
            preTrendlinePoints = computePolyReg(list, parameter);
        } else if (trendline.equals("exponentialMovingAverage")){
            preTrendlinePoints = computeExpMovAvg(list, parameter);
        }

        if (metric.contains("Bandwidth")){
            trendlinePoints = truncateBandwidthValuesFromCoordinateList(preTrendlinePoints);
        } else {
            trendlinePoints = truncateValuesFromCoordinateList(preTrendlinePoints);
        }

        return trendlinePoints;
    }


    private static List<Coordinate> computePolyReg(List<Coordinate> list, Double parameter){

        List<Number> toBeComputed = new ArrayList<>();
        List<Coordinate> preTrendlinePoints = new ArrayList<>();

        for (Coordinate coordinate: list){
            toBeComputed.add(coordinate.getValue());
        }

        Integer N = toBeComputed.size();
        SimpleMatrix X = new SimpleMatrix(0, 0);

        if (parameter.intValue() == 2) {
            X = new SimpleMatrix(N, 3);
        } else if (parameter.intValue() == 3){
            X = new SimpleMatrix(N, 4);
        }

        SimpleMatrix Y = new SimpleMatrix(N, 1);

        for (int i = 0; i < N; i++){
            double y = toBeComputed.get(i).doubleValue();

            if (parameter.intValue() == 2) {
                X.set(i, 0, i * i);
                X.set(i, 1, i);
                X.set(i, 2, 1.0);
            } else if (parameter.intValue() == 3){
                X.set(i, 0, i * i * i);
                X.set(i, 1, i * i);
                X.set(i, 2, i);
                X.set(i, 3, 1.0);
            }

            Y.set(i, 0, y);
        }

        SimpleMatrix Xt = X.transpose();
        SimpleMatrix XtX = Xt.mult(X);
        SimpleMatrix XtY = Xt.mult(Y);

        SimpleMatrix coeffs = XtX.solve(XtY);

        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        double yi = 0;

        if (parameter.intValue() == 2) {
            a = coeffs.get(0, 0);
            b = coeffs.get(1, 0);
            c = coeffs.get(2, 0);
        } else if (parameter.intValue() == 3){
            a = coeffs.get(0, 0);
            b = coeffs.get(1, 0);
            c = coeffs.get(2, 0);
            d = coeffs.get(3, 0);
        }

        for (int i = 0; i < N; i++){
            if (parameter.intValue() == 2) {
                yi = a * i * i + b * i + c;
            } else if (parameter.intValue() == 3){
                yi = a * i * i * i + b * i * i + c * i + d;
            }
            preTrendlinePoints.add(new Coordinate(list.get(i).getTimestamp(), yi));
        }

        return preTrendlinePoints;
    }


    private static List<Coordinate> computeExpMovAvg(List<Coordinate> list, Double alpha){

        List<Coordinate> preTrendlinePoints = new ArrayList<>();

        preTrendlinePoints.add(new Coordinate(list.get(0).getTimestamp(), (list.get(0).getValue())));

        for (int i = 1; i < list.size(); i++){
            double St = alpha * list.get(i).getValue().doubleValue() + (1-alpha) * preTrendlinePoints.get(i-1).getValue().doubleValue();
            preTrendlinePoints.add(new Coordinate(list.get(i).getTimestamp(), St));
        }

        return preTrendlinePoints;
    }
}
