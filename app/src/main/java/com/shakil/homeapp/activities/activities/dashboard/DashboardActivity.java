package com.shakil.homeapp.activities.activities.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {
    private ActivityDashboardBinding activityDashboardBinding;
    private DbHelperParent dbHelperParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);

        init();
        bindUiWithComponents();
        setSupportActionBar(activityDashboardBinding.toolBar);

        activityDashboardBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    //region init objects
    private void init(){
        dbHelperParent = new DbHelperParent(this);
    }
    //endregion

    //region init objects
    private void bindUiWithComponents(){
        activityDashboardBinding.TotalMeters.setText(String.valueOf(dbHelperParent.getTotalMeterRows()));
        activityDashboardBinding.TotalRooms.setText(String.valueOf(dbHelperParent.getTotalRoomRows()));
        activityDashboardBinding.TotalTenants.setText(String.valueOf(dbHelperParent.getTotalTenantRows()));
        activityDashboardBinding.TotalRentAmount.setText(String.valueOf(dbHelperParent.getTotalRentAmount()));
        activityDashboardBinding.TotalElectricityBill.setText(String.valueOf(dbHelperParent.getTotalElectricityBillCollection()));
    }
    //endregion

    //region activity components

    @Override
    public void onBackPressed() {
        startActivity(new Intent(DashboardActivity.this, MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelperParent.close();
    }

    //endregion
}