package com.example.ISPStatDisplay.models.entities.MongoDB;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "server")
public class ServerMongo {

    @Id
    private Long id;

    private Long server_id;

    private String hostname;

    private Long port;

    private String provider;

    private String location;

    private String country;

    private String ip;

    public ServerMongo() {
    }


    public ServerMongo(Long id, Long server_id, String hostname, Long port, String provider, String location, String country, String ip) {
        this.id = id;
        this.server_id = server_id;
        this.hostname = hostname;
        this.port = port;
        this.provider = provider;
        this.location = location;
        this.country = country;
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServer_id() {
        return server_id;
    }

    public void setServer_id(Long server_id) {
        this.server_id = server_id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

