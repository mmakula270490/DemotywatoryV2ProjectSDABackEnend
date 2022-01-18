package com.example.demotywatoryv2.model.dto;


public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "C:/Users/mmakula/Desktop/Demotywator/DemotywatoryFront/DemotywatoryV2ProjectSDAFrontEnd/src/assets";

    public String getLocation(String catalogName) {
        return location + "/" + catalogName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}