package com.shakil.homeapp.activities.activities.meter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.adapter.RecyclerMeterListAdapter;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.meter.Meter;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.RecyclerAdapter;
import java.util.ArrayList;

public class MeterListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMeterList;
    private RecyclerMeterListAdapter recyclerMeterListAdapter;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<Meter> meterList;
    private TextView noDataTXT;
    private Toolbar toolbar;
    private FloatingActionButton addNewDetails;
    //private MeterDbHelper meterDbHelper;
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
        recyclerAdapter.setMeterRecyclerAdapter(recyclerViewMeterList, LinearLayout.VERTICAL,recyclerMeterListAdapter);

        addNewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeterListActivity.this,AddNewMeterActivity.class));
            }
        });
    }

    private void setData() {
        //meterModelList = meterDbHelper.getAllMeterDetails();
        meterList = dbHelperParent.getAllMeterDetails();
        if (meterList.size()<=0){
            noDataTXT.setVisibility(View.VISIBLE);
            noDataTXT.setText(R.string.no_data_message);
        }
    }

    private void init() {
        recyclerViewMeterList = findViewById(R.id.mRecylerView);
        recyclerAdapter = new RecyclerAdapter(this);
        addNewDetails = findViewById(R.id.mAddMeterMaster);
        meterList = new ArrayList<>();
        toolbar = findViewById(R.id.tool_bar);
        //meterDbHelper = new MeterDbHelper(this);
        dbHelperParent = new DbHelperParent(this);
        noDataTXT = findViewById(R.id.mNoDataMessage);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MeterListActivity.this, MainActivity.class));
    }
}