package com.example.hw8a1;

import java.io.Serializable;

public class Location implements Serializable {
    private String planetName;
    private String loc;

    public Location(String planetName, String loc) {
        this.planetName = planetName;
        this.loc = loc;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
