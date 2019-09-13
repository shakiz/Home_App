package com.shakil.homeapp.activities.model;

public class MeterModel {
    private String meterName , associateRoom , meterType , owner , present , past;

    public MeterModel(String meterName, String associateRoom, String meterType, String owner, String present, String past) {
        this.meterName = meterName;
        this.associateRoom = associateRoom;
        this.meterType = meterType;
        this.owner = owner;
        this.present = present;
        this.past = past;
    }

    public MeterModel(String meterName, String associateRoom, String meterType) {
        this.meterName = meterName;
        this.associateRoom = associateRoom;
        this.meterType = meterType;
    }

    public MeterModel(String meterName, String owner, String present, String past) {
        this.meterName = meterName;
        this.owner = owner;
        this.present = present;
        this.past = past;
    }

    public MeterModel() {

    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
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

    public String getAssociateRoom() {
        return associateRoom;
    }

    public void setAssociateRoom(String associateRoom) {
        this.associateRoom = associateRoom;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }
}
