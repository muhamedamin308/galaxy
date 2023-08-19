package com.example.recycleview.database.classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Planet {

    public int radius;
    public String text1;
    public String text2;
    public String description;
    public String type;
    public int yearLength;
    public int imageResource;
    public int planetColor;


    public void setPlanetColor(int planetColor) {
        this.planetColor = planetColor;
    }
    @PrimaryKey(autoGenerate = true)
    int number;

    public Planet(int imageResource, String text1, String text2, String description, int radius, String distanceFromSun, int yearLength, int planetColor) {
        this.imageResource = imageResource;
        this.text1 = text1;
        this.text2 = text2;
        this.description = description;
        this.radius = radius;
        this.type = distanceFromSun;
        this.yearLength = yearLength;
        this.planetColor = planetColor;
    }

    public Planet() {
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRadius() {
        return radius;
    }

    public String getType() {
        return type;
    }

    public int getYearLength() {
        return yearLength;
    }

    public int getPlanetColor() {
        return planetColor;
    }
}
