package com.shakil.homeapp.activities.activities.meter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.databinding.ActivityMeterCostListBinding;

public class MeterCostListActivity extends AppCompatActivity {
    private ActivityMeterCostListBinding activityMeterCostListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMeterCostListBinding = DataBindingUtil.setContentView(this, R.layout.activity_meter_cost_list);

        activityMeterCostListBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
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
        activityMeterCostListBinding.mAddMeterCostMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeterCostListActivity.this, MeterCostDetailsActivity.class));
            }
        });
    }
    //endregion

    //region activity components
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MeterCostListActivity.this, MainActivity.class));
    }
    //endregion
}