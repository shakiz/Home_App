package com.shakil.homeapp.activities.model.meter;

import android.os.Parcel;
import android.os.Parcelable;

public class Meter implements Parcelable {
    private String MeterName;
    private String AssociateRoom;
    private int AssociateRoomId;
    private String MeterType;
    private String MeterTypeName;
    private int MeterTypeId;
    private int PresentUnit;
    private int PastUnit;

    public Meter(String meterName, String associateRoom, String meterType, int presentUnit, int pastUnit) {
        this.MeterName = meterName;
        this.AssociateRoom = associateRoom;
        this.MeterType = meterType;
        this.PresentUnit = presentUnit;
        this.PastUnit = pastUnit;
    }

    public Meter(String meterName, String associateRoom, String meterType) {
        this.MeterName = meterName;
        this.AssociateRoom = associateRoom;
        this.MeterType = meterType;
    }

    public Meter(String meterName, String owner, int presentUnit, int pastUnit) {
        this.MeterName = meterName;
        this.PresentUnit = presentUnit;
        this.PastUnit = pastUnit;
    }

    public Meter() {

    }

    protected Meter(Parcel in) {
        MeterName = in.readString();
        AssociateRoom = in.readString();
        AssociateRoomId = in.readInt();
        MeterType = in.readString();
        MeterTypeName = in.readString();
        MeterTypeId = in.readInt();
        PresentUnit = in.readInt();
        PastUnit = in.readInt();
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

    public String getMeterName() {
        return MeterName;
    }

    public void setMeterName(String meterName) {
        MeterName = meterName;
    }

    public String getAssociateRoom() {
        return AssociateRoom;
    }

    public void setAssociateRoom(String associateRoom) {
        AssociateRoom = associateRoom;
    }

    public int getAssociateRoomId() {
        return AssociateRoomId;
    }

    public void setAssociateRoomId(int associateRoomId) {
        AssociateRoomId = associateRoomId;
    }

    public String getMeterType() {
        return MeterType;
    }

    public void setMeterType(String meterType) {
        MeterType = meterType;
    }

    public String getMeterTypeName() {
        return MeterTypeName;
    }

    public void setMeterTypeName(String meterTypeName) {
        MeterTypeName = meterTypeName;
    }

    public int getMeterTypeId() {
        return MeterTypeId;
    }

    public void setMeterTypeId(int meterTypeId) {
        MeterTypeId = meterTypeId;
    }

    public int getPresentUnit() {
        return PresentUnit;
    }

    public void setPresentUnit(int presentUnit) {
        PresentUnit = presentUnit;
    }

    public int getPastUnit() {
        return PastUnit;
    }

    public void setPastUnit(int pastUnit) {
        PastUnit = pastUnit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(MeterName);
        dest.writeString(AssociateRoom);
        dest.writeInt(AssociateRoomId);
        dest.writeString(MeterType);
        dest.writeString(MeterTypeName);
        dest.writeInt(MeterTypeId);
        dest.writeInt(PresentUnit);
        dest.writeInt(PastUnit);
    }
}
