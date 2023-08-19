package com.example.recycleview.database.classes;

public class Images {
    private String name;
    private final int image;
    private int color;
    private int id;

    public Images(String name, int image, int color, int id) {
        this.name = name;
        this.image = image;
        this.color = color;
        this.id = id;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
