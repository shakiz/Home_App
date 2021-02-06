package com.shakil.homeapp.activities.activities.tenant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.tenant.Tenant;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;
import com.shakil.homeapp.databinding.ActivityAddNewTenantBinding;

import java.util.ArrayList;

public class NewTenantActivity extends AppCompatActivity {
    private ActivityAddNewTenantBinding activityAddNewTenantBinding;
    private Toolbar toolbar;
    private FloatingActionButton actionButton;
    private LinearLayout mainLayout;
    private ArrayList<Tenant> tenantList;
    private DbHelperParent dbHelperParent;
    private SpinnerAdapter spinnerAdapter;
    private SpinnerData spinnerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddNewTenantBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_tenant);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bindUiWithComponents();
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        actionButton = findViewById(R.id.mSaveTenantMaster);
        mainLayout = findViewById(R.id.mainLayout);
        tenantList = new ArrayList<>();
        dbHelperParent = new DbHelperParent(this);
        spinnerData = new SpinnerData(this);
        spinnerAdapter = new SpinnerAdapter();
    }

    private void bindUiWithComponents(){
        spinnerAdapter.setSpinnerAdapter(activityAddNewTenantBinding.MonthSpinner,spinnerData.setMonthData(),this);
        spinnerAdapter.setSpinnerAdapter(activityAddNewTenantBinding.MeterSpinner,spinnerData.setMeterData(),this);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewTenantActivity.this,TenantListActivity.class));
            }
        });
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(NewTenantActivity.this, MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelperParent.close();
    }
}
