package com.shakil.homeapp.activities.model.meter;

public class Meter {
    private String meterName , associateRoom , meterType , owner;
    private int presentUnit, pastUnit;

    public Meter(String meterName, String associateRoom, String meterType, String owner, int presentUnit, int pastUnit) {
        this.meterName = meterName;
        this.associateRoom = associateRoom;
        this.meterType = meterType;
        this.owner = owner;
        this.presentUnit = presentUnit;
        this.pastUnit = pastUnit;
    }

    public Meter(String meterName, String associateRoom, String meterType) {
        this.meterName = meterName;
        this.associateRoom = associateRoom;
        this.meterType = meterType;
    }

    public Meter(String meterName, String owner, int presentUnit, int pastUnit) {
        this.meterName = meterName;
        this.owner = owner;
        this.presentUnit = presentUnit;
        this.pastUnit = pastUnit;
    }

    public Meter() {

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

    public int getPresentUnit() {
        return presentUnit;
    }

    public void setPresentUnit(int presentUnit) {
        this.presentUnit = presentUnit;
    }

    public int getPastUnit() {
        return pastUnit;
    }

    public void setPastUnit(int pastUnit) {
        this.pastUnit = pastUnit;
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
