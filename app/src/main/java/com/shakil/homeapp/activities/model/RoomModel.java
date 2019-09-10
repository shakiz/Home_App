package com.shakil.homeapp.activities.model;

public class RoomModel {
    private String roomName, tenantName, startDate, lastPaidMonth , associateMeter;
    private int advancedAmount;

    public RoomModel(String roomName, String tenantName, String startDate, String lastPaidMonth, String associateMeter, int advancedAmount) {
        this.roomName = roomName;
        this.tenantName = tenantName;
        this.startDate = startDate;
        this.lastPaidMonth = lastPaidMonth;
        this.associateMeter = associateMeter;
        this.advancedAmount = advancedAmount;
    }

    public RoomModel(String roomName, String tenantName, String startDate, String lastPaidMonth) {
        this.roomName = roomName;
        this.tenantName = tenantName;
        this.startDate = startDate;
        this.lastPaidMonth = lastPaidMonth;
    }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLastPaidMonth() {
        return lastPaidMonth;
    }

    public void setLastPaidMonth(String lastPaidMonth) {
        this.lastPaidMonth = lastPaidMonth;
    }
}
