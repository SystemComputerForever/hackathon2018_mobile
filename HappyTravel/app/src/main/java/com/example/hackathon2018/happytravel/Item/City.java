package com.example.hackathon2018.happytravel.Item;

import java.io.Serializable;

/**
 * Created by Benix on 3/11/2018.
 */

public class City implements Serializable {
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
