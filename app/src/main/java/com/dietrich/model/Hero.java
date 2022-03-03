package com.dietrich.model;

public class Hero {
    private int image;
    private String name;
    private String owner;

    public Hero() {}

    public Hero(int image, String name, String owner) {
        this.image = image;
        this.name = name;
        this.owner = owner;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
