package com.example.hackathon2018.happytravel.Item;

import java.io.Serializable;

/**
 * Created by Benix on 3/11/2018.
 */

public class Travelpost implements Serializable {

    public String plan_id, title, country_id, routes, eest_days, start_date, end_date, requirements, images, u_id;

    public Travelpost(String plan_id, String title, String country_id, String routes, String eest_days, String start_date, String end_date, String requirements, String images, String u_id) {
        this.plan_id = plan_id;
        this.title = title;
        this.country_id = country_id;
        this.routes = routes;
        this.eest_days = eest_days;
        this.start_date = start_date;
        this.end_date = end_date;
        this.requirements = requirements;
        this.images = images;
        this.u_id = u_id;
    }

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getRoutes() {
        return routes;
    }

    public void setRoutes(String routes) {
        this.routes = routes;
    }

    public String getEest_days() {
        return eest_days;
    }

    public void setEest_days(String eest_days) {
        this.eest_days = eest_days;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
}
