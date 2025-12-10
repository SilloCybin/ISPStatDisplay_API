package com.example.ISPStatDisplay.models.beans.documents;

import com.example.ISPStatDisplay.models.beans.DownloadTest;
import com.example.ISPStatDisplay.models.beans.IdlePing;
import com.example.ISPStatDisplay.models.beans.UploadTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "speedtest_data")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpeedtestData {

    @Id
    private Long id;

    private Instant timestamp;

    private IdlePing idlePing;

    private DownloadTest downloadTest;

    private UploadTest uploadTest;

    private Float packetLoss;

    private String isp;

    @DBRef
    private Server server;

}
