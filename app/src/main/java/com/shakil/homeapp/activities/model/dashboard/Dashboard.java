package com.shakil.homeapp.activities.model.dashboard;

public class Dashboard {
    private int total_room;
    private int total_meter;
    private int total_earnings;
    private int imageResId;
    private int totalUnit;

    public Dashboard(int total_room, int total_meter, int total_earnings, int imageResId, int totalUnit) {
        this.total_room = total_room;
        this.total_meter = total_meter;
        this.total_earnings = total_earnings;
        this.imageResId = imageResId;
        this.totalUnit = totalUnit;
    }

    public int getTotal_room() {
        return total_room;
    }

    public void setTotal_room(int total_room) {
        this.total_room = total_room;
    }

    public int getTotal_meter() {
        return total_meter;
    }

    public void setTotal_meter(int total_meter) {
        this.total_meter = total_meter;
    }

    public int getTotal_earnings() {
        return total_earnings;
    }

    public void setTotal_earnings(int total_earnings) {
        this.total_earnings = total_earnings;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getTotalUnit() {
        return totalUnit;
    }

    public void setTotalUnit(int totalUnit) {
        this.totalUnit = totalUnit;
    }
}
