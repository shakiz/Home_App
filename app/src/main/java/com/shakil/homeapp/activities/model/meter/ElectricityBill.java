package com.shakil.homeapp.activities.model.meter;

public class ElectricityBill {
    private int BillId;
    private int MeterId;
    private int RoomId;
    private int PresentUnit;
    private int PastUnit;
    private int TotalUnit;
    private int TotalBill;

    public int getBillId() {
        return BillId;
    }

    public void setBillId(int billId) {
        BillId = billId;
    }

    public int getMeterId() {
        return MeterId;
    }

    public void setMeterId(int meterId) {
        MeterId = meterId;
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
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

    public int getTotalUnit() {
        return TotalUnit;
    }

    public void setTotalUnit(int totalUnit) {
        TotalUnit = totalUnit;
    }

    public int getTotalBill() {
        return TotalBill;
    }

    public void setTotalBill(int totalBill) {
        TotalBill = totalBill;
    }
}
