package com.shakil.homeapp.activities.utils;

import android.content.Context;
import android.util.Log;

import com.shakil.homeapp.activities.dbhelper.DbHelperParent;

public class SpinnerData {

    private Context context;
    private DbHelperParent dbHelperParent;

    public SpinnerData(Context context) {
        this.context = context;
        dbHelperParent = new DbHelperParent(context);
    }

    public String[] setMonthData(){
        String[] spinnerValues = {"Select Data","January","February","March","April","May","June","July","August","September","October","November","December"};
        return spinnerValues;
    }

    public String[] setMeterData(){
        String[] spinnerValues = dbHelperParent.getMeterNames().toArray(new String[dbHelperParent.getMeterNames().size()]);
        return spinnerValues;
    }

    public String[] setMeterTypeData(){
        String[] spinnerValues = {"Select Data","Main Meter","Sub Meter"};
        return spinnerValues;
    }

    public String[] setRoomData(){
        String[] spinnerValues = {"Select Data","Room 1","Room 2","Room 3","Room 4"};
        return spinnerValues;
    }
}
