package com.shakil.homeapp.activities.model.room;

public class Room {
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
}
