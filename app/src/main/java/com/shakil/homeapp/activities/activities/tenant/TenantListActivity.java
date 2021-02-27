package com.shakil.homeapp.activities.activities.tenant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.meter.MeterListActivity;
import com.shakil.homeapp.activities.activities.meter.NewMeterActivity;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.adapter.RecyclerMeterListAdapter;
import com.shakil.homeapp.activities.adapter.RecyclerTenantListAdapter;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.meter.Meter;
import com.shakil.homeapp.activities.model.tenant.Tenant;
import com.shakil.homeapp.databinding.ActivityTenantListBinding;

import java.util.ArrayList;

public class TenantListActivity extends AppCompatActivity {
    private ActivityTenantListBinding activityTenantListBinding;
    private RecyclerTenantListAdapter recyclerTenantListAdapter;
    private ArrayList<Tenant> tenantList;
    private TextView noDataTXT;
    private DbHelperParent dbHelperParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTenantListBinding = DataBindingUtil.setContentView(this, R.layout.activity_tenant_list);

        init();

        setSupportActionBar(activityTenantListBinding.toolBar);

        activityTenantListBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenantListActivity.this, MainActivity.class));
            }
        });

        binUiWithComponents();
    }

    private void init() {
        tenantList = new ArrayList<>();
        dbHelperParent = new DbHelperParent(this);
        noDataTXT = findViewById(R.id.mNoDataMessage);
    }

    private void binUiWithComponents(){
        setData();

        recyclerTenantListAdapter = new RecyclerTenantListAdapter(tenantList, this);
        activityTenantListBinding.mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        activityTenantListBinding.mRecylerView.setAdapter(recyclerTenantListAdapter);
        recyclerTenantListAdapter.notifyDataSetChanged();
        recyclerTenantListAdapter.setOnItemClickListener(new RecyclerTenantListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Tenant tenant) {
                startActivity(new Intent(TenantListActivity.this, NewTenantActivity.class).putExtra("tenant", tenant));
            }
        });

        activityTenantListBinding.mAddTenantMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TenantListActivity.this, NewTenantActivity.class));
            }
        });
    }

    private void setData() {
        tenantList = dbHelperParent.getAllTenantDetails();
        if (tenantList.size() <= 0){
            noDataTXT.setVisibility(View.VISIBLE);
            noDataTXT.setText(R.string.no_data_message);
        }
    }

    //region activity components

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TenantListActivity.this, MainActivity.class));
    }

    //endregion
}
