package com.example.hackathon2018.happytravel.Item;

import java.io.Serializable;

/**
 * Created by Benix on 3/11/2018.
 */

public class Travelpost implements Serializable{
    public Travelpost(String title, String photo, String location, String startdate) {
        this.title = title;
        this.photo = photo;
        this.location = location;
        this.startdate = startdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String title,photo,location,startdate;
}
