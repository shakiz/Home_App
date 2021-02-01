package com.shakil.homeapp.activities.model.room;

import android.os.Parcel;
import android.os.Parcelable;

public class Room implements Parcelable {
    private String roomName, tenantName, startMonth, lastPaidMonth , associateMeter;
    private int advancedAmount;

    public Room() {
    }

    public Room(String roomName, String tenantName, String startMonth, String lastPaidMonth, String associateMeter, int advancedAmount) {
        this.roomName = roomName;
        this.tenantName = tenantName;
        this.startMonth = startMonth;
        this.lastPaidMonth = lastPaidMonth;
        this.associateMeter = associateMeter;
        this.advancedAmount = advancedAmount;
    }

    public Room(String roomName, String tenantName, String startMonth, String lastPaidMonth) {
        this.roomName = roomName;
        this.tenantName = tenantName;
        this.startMonth = startMonth;
        this.lastPaidMonth = lastPaidMonth;
    }

    protected Room(Parcel in) {
        roomName = in.readString();
        tenantName = in.readString();
        startMonth = in.readString();
        lastPaidMonth = in.readString();
        associateMeter = in.readString();
        advancedAmount = in.readInt();
    }

    public static final Creator<Room> CREATOR = new Creator<Room>() {
        @Override
        public Room createFromParcel(Parcel in) {
            return new Room(in);
        }

        @Override
        public Room[] newArray(int size) {
            return new Room[size];
        }
    };

    public String getAssociateMeter() {
        return associateMeter;
    }

    public void setAssociateMeter(String associateMeter) {
        this.associateMeter = associateMeter;
    }

    public int getAdvancedAmount() {
        return advancedAmount;
    }

    public void setAdvancedAmount(int advancedAmount) {
        this.advancedAmount = advancedAmount;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenant) {
        this.tenantName = tenant;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getLastPaidMonth() {
        return lastPaidMonth;
    }

    public void setLastPaidMonth(String lastPaidMonth) {
        this.lastPaidMonth = lastPaidMonth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(roomName);
        dest.writeString(tenantName);
        dest.writeString(startMonth);
        dest.writeString(lastPaidMonth);
        dest.writeString(associateMeter);
        dest.writeInt(advancedAmount);
    }
}
