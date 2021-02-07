package com.shakil.homeapp.activities.activities.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.databinding.ActivityRentListBinding;

public class RentListActivity extends AppCompatActivity {
    private ActivityRentListBinding activityRentListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRentListBinding = DataBindingUtil.setContentView(this, R.layout.activity_rent_list);

        activityRentListBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //region init UI and perform all UI interactions
        init();
        bindUIWithComponents();
        //endregion
    }

    //region init components
    private void init(){

    }
    //endregion

    //region perform all UI interactions
    private void bindUIWithComponents(){
        activityRentListBinding.mAddRentMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RentListActivity.this, RentDetailsActivity.class));
            }
        });
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(RentListActivity.this, MainActivity.class));
    }
    //endregion
}