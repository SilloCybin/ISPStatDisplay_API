package com.example.ISPStatDisplay.models.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {

    private Instant timestamp;

    private Number value;

}