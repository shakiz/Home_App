package com.shakil.homeapp.activities.utils;

import android.content.Context;
import android.content.Intent;

public class UtilsForAll {

    private Context context;

    public UtilsForAll(Context context) {
        this.context = context;
    }

    public void exitApp(){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(exitIntent);
    }
}
