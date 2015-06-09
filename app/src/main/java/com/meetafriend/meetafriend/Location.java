package com.meetafriend.meetafriend;

/**
 * Created by briang on 8-6-2015.
 */
public class Location {
    private String longitude;
    private String latitude;

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }
}
