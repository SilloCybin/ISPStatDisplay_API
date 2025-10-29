package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.SpeedtestData;
import com.example.ISPStatDisplay.services.SpeedTestStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class SpeedTestStatsController {

    @Autowired
    private final SpeedTestStatsService service = new SpeedTestStatsService();

    @GetMapping("/SpeedtestData/{id}")
    public ResponseEntity<SpeedtestData> getSpeedTestData(@PathVariable Long id) {
        try {
            SpeedtestData sts = service.getSpeedTestData(id).get();
            return new ResponseEntity<>(sts, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getLatestSpeedtestData")
    public ResponseEntity<SpeedtestData> getLatestSpeedtestData() {
        try {
            Long idOfLatest = service.getIDOfLatest();
            SpeedtestData data = service.getSpeedTestData(idOfLatest).get();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll/{metric}")
    public ResponseEntity<List<MetricPoint>> getAll(@PathVariable String metric) {
        List<MetricPoint> data = service.getAll(metric);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/fromStartDate/{metric}")
    public ResponseEntity<List<MetricPoint>> getMetricFromStartDateToNow(
            @PathVariable String metric,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        Date convertedStartDate = Date.from(startDateTime.atZone(ZoneId.of("Europe/Lisbon")).toInstant());

        List<MetricPoint> data = service.getMetricFromStartDateToNow(metric, convertedStartDate);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/dateRange/{metric}")
    public ResponseEntity<List<MetricPoint>> getMetricOnDateRange(
            @PathVariable String metric,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        Date convertedStartDate = Date.from(startDateTime.atZone(ZoneId.of("Europe/Lisbon")).toInstant());

        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        Date convertedEndDate = Date.from(endDateTime.atZone(ZoneId.of("Europe/Lisbon")).toInstant());

        List<MetricPoint> data = service.getMetricOnDateRange(metric, convertedStartDate, convertedEndDate);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}