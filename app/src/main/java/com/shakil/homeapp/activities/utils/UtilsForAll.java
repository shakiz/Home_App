package com.shakil.homeapp.activities.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.shakil.homeapp.R;

public class UtilsForAll {

    private Context context;
    private View view;

    public UtilsForAll(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public UtilsForAll(Context context) {
        this.context = context;
    }

    public UtilsForAll(View view) {
        this.view = view;
    }

    public void exitApp(){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(exitIntent);
    }

    public void setCustomDesignTextView(int resId){
        TextView textView = view.findViewById(resId);
        textView.setTextColor(view.getResources().getColor(R.color.md_blue_grey_800));
        textView.setSingleLine();
    }
}
