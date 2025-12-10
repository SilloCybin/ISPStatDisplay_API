package com.example.ISPStatDisplay.models.beans.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "server")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {

    @Id
    private Long id;

    private Long server_id;

    private String hostname;

    private Long port;

    private String provider;

    private String location;

    private String country;

    private String ip;

}

