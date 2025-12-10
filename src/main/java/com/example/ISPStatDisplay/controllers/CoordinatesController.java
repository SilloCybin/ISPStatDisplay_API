package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.CoordinateDTO;
import com.example.ISPStatDisplay.services.CoordinatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoordinatesController {

    private final CoordinatesService metricPointservice;

    @GetMapping("/getSeries")
    public ResponseEntity<List<CoordinateDTO>> getSeries(
            @RequestParam(required = true) String metric,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate,
            @RequestParam(required = false) String trendline,
            @RequestParam(required = false) Double parameter){

        List<CoordinateDTO> data;

        if (startDate != null){
            if (endDate != null){
                if (trendline != null){
                    data = this.metricPointservice.getTrendlineOnDateRange(metric, trendline, startDate, endDate, parameter);
                } else {
                    data = this.metricPointservice.getMetricOnDateRange(metric, startDate, endDate);
                }
            } else {
                if (trendline != null){
                    data = this.metricPointservice.getTrendlineFromStartDateToNow(metric, trendline, startDate, parameter);
                } else {
                    data = this.metricPointservice.getMetricFromStartDateToNow(metric, startDate);
                }
            }
        } else {
            if (trendline != null){
                data = this.metricPointservice.getEntireTrendline(metric, trendline, parameter);
            } else {
                data = this.metricPointservice.getAll(metric);
            }
        }

        if (!data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
