package com.example.ISPStatDisplay.models.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadTest {

    private Long bandwidth;

    private Long bytes;

    private Float elapsed;

    private DownloadPing downloadPing;

}
