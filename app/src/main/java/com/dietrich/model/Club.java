package com.dietrich.model;

import java.io.Serializable;
import java.util.List;

public class Club implements Serializable {
    private int emblem;
    private String name;
    private String city;
    private List<Title> titles;

    public Club(int emblem, String name, String city, List<Title> titles) {
        this.emblem = emblem;
        this.name = name;
        this.city = city;
        this.titles = titles;
    }

    public int getEmblem() {
        return emblem;
    }

    public void setEmblem(int emblem) {
        this.emblem = emblem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }
}
