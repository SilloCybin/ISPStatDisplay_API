package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.MetricPoint;
import com.example.ISPStatDisplay.models.SpeedtestData;
import com.example.ISPStatDisplay.services.SpeedTestStatsService;
import com.example.ISPStatDisplay.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class SpeedTestStatsController {

    @Autowired
    private final SpeedTestStatsService service = new SpeedTestStatsService();

    @GetMapping("/SpeedtestData/{id}")
    public ResponseEntity<SpeedtestData> getSpeedTestData(@PathVariable Long id){
        try{
            SpeedtestData sts = service.getSpeedTestData(id).get();
            return new ResponseEntity<>(sts, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getLatestSpeedtestData")
    public ResponseEntity<SpeedtestData> getLatestSpeedtestData(){
        try{
            Long idOfLatest = service.getIDOfLatest();
            SpeedtestData data = service.getSpeedTestData(idOfLatest).get();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllDownloadBandwidth")
    public ResponseEntity<List<MetricPoint>> getAllDownloadBandwidths(){
        List<MetricPoint> data = Utilities.truncateBandwidthValue(service.getAllDownloadBandwidths());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllUploadBandwidth")
    public ResponseEntity<List<MetricPoint>> getAllUploadBandwidths(){
        List<MetricPoint> data = Utilities.truncateBandwidthValue(service.getAllUploadBandwidths());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllDownloadPingLatency")
    public ResponseEntity<List<MetricPoint>> getAllDownloadingLatencies(){
        List<MetricPoint> data = service.getAllDownloadPingLatencies();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllUploadPingLatency")
    public ResponseEntity<List<MetricPoint>> getAllUploadPingLatencies(){
        List<MetricPoint> data = service.getAllUploadPingLatencies();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllIdlePingLatency")
    public ResponseEntity<List<MetricPoint>> getAllIdlePingLatencies(){
        List<MetricPoint> data = service.getAllIdlePingLatencies();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllDownloadPingLow")
    public ResponseEntity<List<MetricPoint>> getAllDownloadPingLows(){
        List<MetricPoint> data = service.getAllDownloadPingLows();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllUploadPingLow")
    public ResponseEntity<List<MetricPoint>> getAllUploadPingLows(){
        List<MetricPoint> data = service.getAllUploadPingLows();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllIdlePingLow")
    public ResponseEntity<List<MetricPoint>> getAllIdlePingLows(){
        List<MetricPoint> data = service.getAllIdlePingLows();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllDownloadPingHigh")
    public ResponseEntity<List<MetricPoint>> getAllDownloadPingHighs(){
        List<MetricPoint> data = service.getAllDownloadPingHighs();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllUploadPingHigh")
    public ResponseEntity<List<MetricPoint>> getAllUploadPingHighs(){
        List<MetricPoint> data = service.getAllUploadPingHighs();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllIdlePingHigh")
    public ResponseEntity<List<MetricPoint>> getAllIdlePingHighs(){
        List<MetricPoint> data = service.getAllIdlePingHighs();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllDownloadPingJitter")
    public ResponseEntity<List<MetricPoint>> getAllDownloadingJitters(){
        List<MetricPoint> data = service.getAllDownloadPingJitters();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllUploadPingJitter")
    public ResponseEntity<List<MetricPoint>> getAllUploadPingJitters(){
        List<MetricPoint> data = service.getAllUploadPingJitters();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllIdlePingJitter")
    public ResponseEntity<List<MetricPoint>> getAllIdlePingJitters(){
        List<MetricPoint> data = service.getAllIdlePingJitters();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getAllPacketLoss")
    public ResponseEntity<List<MetricPoint>> getAllPacketLoss(){
        List<MetricPoint> data = Utilities.truncatePacketLossValue(service.getAllPacketLoss());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}