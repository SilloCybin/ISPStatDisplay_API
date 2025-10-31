package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.records.MetricPointDTO;
import com.example.ISPStatDisplay.services.MetricPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class MetricPointController {

    private final MetricPointService metricPointservice;

    public MetricPointController(MetricPointService metricPointservice){
        this.metricPointservice = metricPointservice;
    }

    @GetMapping("/getAll/{metric}")
    public ResponseEntity<List<MetricPointDTO>> getAll(@PathVariable String metric) {
        List<MetricPointDTO> data = this.metricPointservice.getAll(metric);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/fromStartDate/{metric}")
    public ResponseEntity<List<MetricPointDTO>> getMetricFromStartDateToNow(
            @PathVariable String metric,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        Date convertedStartDate = Date.from(startDateTime.atZone(ZoneId.of("Europe/Lisbon")).toInstant());

        List<MetricPointDTO> data = this.metricPointservice.getMetricFromStartDateToNow(metric, convertedStartDate);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/dateRange/{metric}")
    public ResponseEntity<List<MetricPointDTO>> getMetricOnDateRange(
            @PathVariable String metric,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        Date convertedStartDate = Date.from(startDateTime.atZone(ZoneId.of("Europe/Lisbon")).toInstant());

        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);
        Date convertedEndDate = Date.from(endDateTime.atZone(ZoneId.of("Europe/Lisbon")).toInstant());

        List<MetricPointDTO> data = this.metricPointservice.getMetricOnDateRange(metric, convertedStartDate, convertedEndDate);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
