package com.shakil.homeapp.activities.model.meter;

import android.os.Parcel;
import android.os.Parcelable;

public class Meter implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(meterName);
        dest.writeString(associateRoom);
        dest.writeString(meterType);
        dest.writeString(owner);
        dest.writeInt(presentUnit);
        dest.writeInt(pastUnit);
    }

    protected Meter(Parcel in) {
        meterName = in.readString();
        associateRoom = in.readString();
        meterType = in.readString();
        owner = in.readString();
        presentUnit = in.readInt();
        pastUnit = in.readInt();
    }

    public static final Creator<Meter> CREATOR = new Creator<Meter>() {
        @Override
        public Meter createFromParcel(Parcel in) {
            return new Meter(in);
        }

        @Override
        public Meter[] newArray(int size) {
            return new Meter[size];
        }
    };
}
