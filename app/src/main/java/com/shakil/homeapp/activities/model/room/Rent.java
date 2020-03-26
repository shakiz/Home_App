package com.shakil.homeapp.activities.model.room;

public class Rent {
    private String rentForMonth , rentRoom;
    private int rentAmount;


    public Rent(String rentForMonth, String rentRoom, int rentAmount) {
        this.rentForMonth = rentForMonth;
        this.rentRoom = rentRoom;
        this.rentAmount = rentAmount;
    }

    public Rent() {

    }

    public String getRentForMonth() {
        return rentForMonth;
    }

    public void setRentForMonth(String rentForMonth) {
        this.rentForMonth = rentForMonth;
    }

    public String getRentRoom() {
        return rentRoom;
    }

    public void setRentRoom(String rentRoom) {
        this.rentRoom = rentRoom;
    }

    public int getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }
}