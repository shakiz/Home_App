package com.shakil.homeapp.activities.meter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meter_list);

        init();

        binUiWIthComponents();
    }

    private void binUiWIthComponents() {

        setData();

        recyclerMeterListAdapter = new RecyclerMeterListAdapter(meterModelList , this);
        recyclerAdapter.setMeterRecyclerAdapter(recyclerViewMeterList, LinearLayout.VERTICAL,recyclerMeterListAdapter);
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
        meterModelList = new ArrayList<>();
    }
}
