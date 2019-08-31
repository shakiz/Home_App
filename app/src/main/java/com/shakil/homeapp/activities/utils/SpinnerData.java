package com.shakil.homeapp.activities.utils;


public class SpinnerData {

    public String[] setMonthData(){
        String[] spinnerValues = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return spinnerValues;
    }

    public String[] setMeterData(){
        String[] spinnerValues = {"Meter 1","Meter 2","Meter 3","Meter 4"};
        return spinnerValues;
    }

    public String[] setMeterTypeData(){
        String[] spinnerValues = {"Main Meter","Sub Meter"};
        return spinnerValues;
    }

    public String[] setRoomData(){
        String[] spinnerValues = {"Room 1","Room 2","Room 3","Room 4"};
        return spinnerValues;
    }
}
