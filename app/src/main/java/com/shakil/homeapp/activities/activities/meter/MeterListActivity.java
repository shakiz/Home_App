package com.shakil.homeapp.activities.activities.meter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.adapter.RecyclerMeterListAdapter;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.meter.Meter;

import java.util.ArrayList;

public class MeterListActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMeterList;
    private RecyclerMeterListAdapter recyclerMeterListAdapter;
    private ArrayList<Meter> meterList;
    private TextView noDataTXT;
    private Toolbar toolbar;
    private FloatingActionButton addNewDetails;
    private DbHelperParent dbHelperParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter_list);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeterListActivity.this,MainActivity.class));
            }
        });

        binUiWIthComponents();
    }

    private void binUiWIthComponents() {
        setData();

        recyclerMeterListAdapter = new RecyclerMeterListAdapter(meterList, this);
        recyclerViewMeterList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMeterList.setAdapter(recyclerMeterListAdapter);
        recyclerMeterListAdapter.notifyDataSetChanged();
        recyclerMeterListAdapter.setOnItemClickListener(new RecyclerMeterListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Meter meter) {
                startActivity(new Intent(MeterListActivity.this, NewMeterActivity.class).putExtra("meter", meter));
            }
        });

        addNewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeterListActivity.this, NewMeterActivity.class));
            }
        });
    }

    private void setData() {
        meterList = dbHelperParent.getAllMeterDetails();
        if (meterList.size() <= 0){
            noDataTXT.setVisibility(View.VISIBLE);
            noDataTXT.setText(R.string.no_data_message);
        }
    }

    private void init() {
        recyclerViewMeterList = findViewById(R.id.mRecylerView);
        addNewDetails = findViewById(R.id.mAddMeterMaster);
        meterList = new ArrayList<>();
        toolbar = findViewById(R.id.tool_bar);
        dbHelperParent = new DbHelperParent(this);
        noDataTXT = findViewById(R.id.mNoDataMessage);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MeterListActivity.this, MainActivity.class));
    }
}
