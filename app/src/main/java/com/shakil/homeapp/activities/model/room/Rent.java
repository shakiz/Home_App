package com.shakil.homeapp.activities.model.room;

public class Rent {
    private int RentId;
    private String MonthName;
    private int MonthId;
    private String AssociateRoomName;
    private int AssociateRoomId;
    private int rentAmount;

    public Rent(String rentForMonth, String rentRoom, int rentAmount) {
        this.MonthName = rentForMonth;
        this.AssociateRoomName = rentRoom;
        this.rentAmount = rentAmount;
    }

    public Rent() {

    }

    public int getRentId() {
        return RentId;
    }

    public void setRentId(int rentId) {
        RentId = rentId;
    }

    public String getMonthName() {
        return MonthName;
    }

    public void setMonthName(String monthName) {
        MonthName = monthName;
    }

    public int getMonthId() {
        return MonthId;
    }

    public void setMonthId(int monthId) {
        MonthId = monthId;
    }

    public String getAssociateRoomName() {
        return AssociateRoomName;
    }

    public void setAssociateRoomName(String associateRoomName) {
        AssociateRoomName = associateRoomName;
    }

    public int getAssociateRoomId() {
        return AssociateRoomId;
    }

    public void setAssociateRoomId(int associateRoomId) {
        AssociateRoomId = associateRoomId;
    }

    public int getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }
}
