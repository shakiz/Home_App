package com.shakil.homeapp.activities.model;

public class MeterModel {
    private String name , owner , present , past;

    public MeterModel(String name, String owner, String present, String past) {
        this.name = name;
        this.owner = owner;
        this.present = present;
        this.past = past;
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

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getPast() {
        return past;
    }

    public void setPast(String past) {
        this.past = past;
    }
}
