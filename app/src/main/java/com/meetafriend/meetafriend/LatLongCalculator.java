package com.meetafriend.meetafriend;

/**
 * Created by weseykone on 15-6-2015.
 */
public class LatLongCalculator {

    double lat;
    double lon;
    double R;
    double dne1;
    double dne2;
    double dnw1;
    double dnw2;
    double dsw1;
    double dsw2;
    double dse1;
    double dse2;
    double dLat;
    double dLon;
    double Pi = Math.PI;

    double[] latitudeArray = new double[5];
    double[] longtitudeArray = new double[5];
    int i = 0;

    public void calculateDistance(double latitude, double longtitude, double distance1, double distance2) {
        //Position, decimal degrees
        lat = latitude;
        lon = longtitude;

        //Earth’s radius, sphere
        R=6378137;

        //Coordinate offsets in radians
        dLat = distance1/R;
        dLon = distance2 / (R * Math.cos(Pi*lat/180));

        //OffsetPosition, decimal degrees
        latitudeArray[i] = lat + dLat * 180/Pi;
        longtitudeArray[i] = lon + dLon * 180/Pi;
        // write your code here
        System.out.print ("Latitude: " + latitudeArray[i] + "  " + "Longtitude: " + longtitudeArray[i] + "\n" + i + "\n");

        i++;
    }

    public void offset(double latitude, double longtitude, double distance1, double distance2) {
        //offsets in meters
        dne1 = (distance1) / 1.4; // dne stands for distance north east with 1 being north and 2 being east
        dne2 = (distance2) / 1.4;

        dnw1 = (distance1) / 1.4; // dnw stands for distance north west with 1 being north and 2 being west
        dnw2 = (distance2 * -1) / 1.4;

        dsw1 = (distance1 * -1) / 1.4; // dsw stands for distance north east with 1 being south and 2 being west
        dsw2 = (distance2 * -1) / 1.4;

        dse1 = (distance1 * -1) / 1.4; // dne stands for distance north east with 1 being south and 2 being east
        dse2 = (distance2) / 1.4;

        calculateDistance(latitude, longtitude, dne1, dne2);
        calculateDistance(latitude, longtitude, dnw1, dnw2);
        calculateDistance(latitude, longtitude, dsw1, dsw2);
        calculateDistance(latitude, longtitude, dse1, dse2);
    }
}
