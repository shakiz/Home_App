package com.shakil.homeapp.activities.model;

public class RoomModel {
    private String roomName, ownerName, startDate, lastPaidMonth;

    public RoomModel(String roomName, String ownerName, String startDate, String lastPaidMonth) {
        this.roomName = roomName;
        this.ownerName = ownerName;
        this.startDate = startDate;
        this.lastPaidMonth = lastPaidMonth;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
