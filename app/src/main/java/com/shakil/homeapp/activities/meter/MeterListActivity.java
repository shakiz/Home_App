package com.shakil.homeapp.activities.meter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.adapter.RecyclerMeterListAdapter;
import com.shakil.homeapp.activities.model.MeterModel;
import com.shakil.homeapp.activities.utils.RecyclerAdapter;
import java.util.ArrayList;

public class MeterListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMeterList;
    private RecyclerMeterListAdapter recyclerMeterListAdapter;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<MeterModel> meterModelList;
    private Toolbar toolbar;
    private FloatingActionButton addNewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter_list);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binUiWIthComponents();
    }

    private void binUiWIthComponents() {

        setData();

        recyclerMeterListAdapter = new RecyclerMeterListAdapter(meterModelList , this);
        recyclerAdapter.setMeterRecyclerAdapter(recyclerViewMeterList, LinearLayout.VERTICAL,recyclerMeterListAdapter);

        addNewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeterListActivity.this,NewMeterDetailsActivity.class));
            }
        });
    }

    private void setData() {
        meterModelList.add(new MeterModel("Meter 1","Rahman","3254","3310"));
        meterModelList.add(new MeterModel("Meter 1","Rahman","3254","3310"));
        meterModelList.add(new MeterModel("Meter 1","Rahman","3254","3310"));
        meterModelList.add(new MeterModel("Meter 1","Rahman","3254","3310"));
        meterModelList.add(new MeterModel("Meter 1","Rahman","3254","3310"));
        meterModelList.add(new MeterModel("Meter 1","Rahman","3254","3310"));
        meterModelList.add(new MeterModel("Meter 1","Rahman","3254","3310"));
    }

    private void init() {
        recyclerViewMeterList = findViewById(R.id.mRecylerView);
        recyclerAdapter = new RecyclerAdapter(this);
        addNewDetails = findViewById(R.id.mAddMeterMaster);
        meterModelList = new ArrayList<>();
        toolbar = findViewById(R.id.tool_bar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
