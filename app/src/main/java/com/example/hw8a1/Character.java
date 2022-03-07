package com.example.hw8a1;

import java.io.Serializable;

public class Character implements Serializable {

    private int image;
    private String status;
    private String name;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Character(int image, String status, String name) {
        this.image = image;
        this.status = status;
        this.name = name;
    }
}
