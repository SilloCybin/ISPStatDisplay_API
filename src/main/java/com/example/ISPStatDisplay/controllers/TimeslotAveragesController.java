package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.CoordinateDTO;
import com.example.ISPStatDisplay.models.DTOs.TimeslotAveragesDTO;
import com.example.ISPStatDisplay.services.CoordinatesService;
import com.example.ISPStatDisplay.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TimeslotAveragesController {

    private final CoordinatesService coordinatesService;

    @GetMapping("/getTimeslotAverages")
    public ResponseEntity<List<TimeslotAveragesDTO>> getHeatmapAggregate(
        @RequestParam(required = true) String metric){

        List<CoordinateDTO> series = this.coordinatesService.getAll(metric);
        List<TimeslotAveragesDTO> timeslotAveragesDTOList;

        if (!series.isEmpty()){
            timeslotAveragesDTOList = Utilities.seriesToTimeslotAverages(series, metric);
            return new ResponseEntity<>(timeslotAveragesDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}