package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.CoordinateDTO;
import com.example.ISPStatDisplay.services.CoordinatesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.util.List;
import java.util.Objects;

@RestController
public class CoordinatesController {

    private final CoordinatesService metricPointservice;

    public CoordinatesController(CoordinatesService metricPointservice){
        this.metricPointservice = metricPointservice;
    }


    /*
    Metric series endpoints
     */

    @GetMapping("/getAll/{metric}")
    public ResponseEntity<List<CoordinateDTO>> getAll(@PathVariable String metric) {
        List<CoordinateDTO> data = this.metricPointservice.getAll(metric);

        if (!data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromStartDate/{metric}")
    public ResponseEntity<List<CoordinateDTO>> getMetricFromStartDateToNow(
            @PathVariable String metric,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate) {

        List<CoordinateDTO> data = this.metricPointservice.getMetricFromStartDateToNow(metric, startDate);

        if (!data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dateRange/{metric}")
    public ResponseEntity<List<CoordinateDTO>> getMetricOnDateRange(
            @PathVariable String metric,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate) {

        List<CoordinateDTO> data = this.metricPointservice.getMetricOnDateRange(metric, startDate, endDate);

        if (!data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /*
    Trendline endpoints
     */

    @GetMapping("/getEntireTrendline/{metric}/{trendline}")
    public ResponseEntity<List<CoordinateDTO>> getEntireTrendline(
            @PathVariable String metric,
            @PathVariable String trendline,
            @RequestParam(required = false) Double alpha,
            @RequestParam(required = false) Double degree) {

        Double parameter = null;

        if (alpha != null && degree == null){
            parameter = alpha;
        } else if (degree != null && alpha == null) {
            parameter = degree;
        }

        List <CoordinateDTO> data = this.metricPointservice.getEntireTrendline(
                metric,
                trendline,
                Objects.requireNonNullElse(parameter, -1D));

        if (!data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTrendlineFromStartDate/{metric}/{trendline}")
    public ResponseEntity<List<CoordinateDTO>> getTrendlineFromStartDateToNow(
            @PathVariable String metric,
            @PathVariable String trendline,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate,
            @RequestParam(required = false) Double alpha,
            @RequestParam(required = false) Double degree) {

        Double parameter = null;

        if (alpha != null && degree == null){
            parameter = alpha;
        } else if (degree != null && alpha == null) {
            parameter = degree;
        }

        List<CoordinateDTO> data = this.metricPointservice.getTrendlineFromStartDateToNow(
                metric,
                trendline,
                startDate,
                Objects.requireNonNullElse(parameter, -1D));

        if (!data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTrendlineOnDateRange/{metric}/{trendline}")
    public ResponseEntity<List<CoordinateDTO>> getTrendlineOnDateRange(
            @PathVariable String metric,
            @PathVariable String trendline,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate,
            @RequestParam(required = false) Double alpha,
            @RequestParam(required = false) Double degree) {

        Double parameter = null;

        if (alpha != null && degree == null){
            parameter = alpha;
        } else if (degree != null && alpha == null) {
            parameter = degree;
        }

        List<CoordinateDTO> data = this.metricPointservice.getTrendlineOnDateRange(
                metric,
                trendline,
                startDate,
                endDate,
                Objects.requireNonNullElse(parameter, -1D));

        if (!data.isEmpty()) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
