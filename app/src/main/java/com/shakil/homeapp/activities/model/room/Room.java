package com.shakil.homeapp.activities.model.room;

import android.os.Parcel;
import android.os.Parcelable;

public class Room implements Parcelable {
    private String RoomName;
    private String TenantName;
    private String StartMonthName;
    private int StartMonthId;
    private String LastPaidMonth;
    private String AssociateMeterName;
    private int AssociateMeterId;
    private int AdvancedAmount;

    public Room() {
    }

    public Room(String roomName, String tenantName, String startMonth, String lastPaidMonth, String associateMeter, int advancedAmount) {
        this.RoomName = roomName;
        this.TenantName = tenantName;
        this.StartMonthName = startMonth;
        this.LastPaidMonth = lastPaidMonth;
        this.AssociateMeterName = associateMeter;
        this.AdvancedAmount = advancedAmount;
    }

    public Room(String roomName, String tenantName, String startMonth, String lastPaidMonth) {
        this.RoomName = roomName;
        this.TenantName = tenantName;
        this.StartMonthName = startMonth;
        this.LastPaidMonth = lastPaidMonth;
    }

    protected Room(Parcel in) {
        RoomName = in.readString();
        TenantName = in.readString();
        StartMonthName = in.readString();
        LastPaidMonth = in.readString();
        AssociateMeterName = in.readString();
        AdvancedAmount = in.readInt();
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

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public String getTenantName() {
        return TenantName;
    }

    public void setTenantName(String tenantName) {
        TenantName = tenantName;
    }

    public String getStartMonthName() {
        return StartMonthName;
    }

    public void setStartMonthName(String startMonthName) {
        StartMonthName = startMonthName;
    }

    public int getStartMonthId() {
        return StartMonthId;
    }

    public void setStartMonthId(int startMonthId) {
        StartMonthId = startMonthId;
    }

    public String getLastPaidMonth() {
        return LastPaidMonth;
    }

    public void setLastPaidMonth(String lastPaidMonth) {
        LastPaidMonth = lastPaidMonth;
    }

    public String getAssociateMeterName() {
        return AssociateMeterName;
    }

    public void setAssociateMeterName(String associateMeterName) {
        AssociateMeterName = associateMeterName;
    }

    public int getAssociateMeterId() {
        return AssociateMeterId;
    }

    public void setAssociateMeterId(int associateMeterId) {
        AssociateMeterId = associateMeterId;
    }

    public int getAdvancedAmount() {
        return AdvancedAmount;
    }

    public void setAdvancedAmount(int advancedAmount) {
        AdvancedAmount = advancedAmount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(RoomName);
        dest.writeString(TenantName);
        dest.writeString(StartMonthName);
        dest.writeString(LastPaidMonth);
        dest.writeString(AssociateMeterName);
        dest.writeInt(AdvancedAmount);
    }
}
