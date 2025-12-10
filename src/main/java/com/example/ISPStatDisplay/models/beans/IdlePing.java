package com.example.ISPStatDisplay.models.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdlePing {

    private Float jitter;

    private Float latency;

    private Float low;

    private Float high;

}
