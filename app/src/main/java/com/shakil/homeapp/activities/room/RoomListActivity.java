package com.shakil.homeapp.activities.room;

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
import com.shakil.homeapp.activities.adapter.RecyclerRoomListAdapter;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.RoomModel;
import com.shakil.homeapp.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.RecyclerAdapter;
import java.util.ArrayList;

public class RoomListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMeterList;
    private RecyclerRoomListAdapter recyclerRoomListAdapter;
    private RecyclerAdapter recyclerAdapter;
    private TextView noDataTXT;
    private ArrayList<RoomModel> roomModelList;
    private Toolbar toolbar;
    private FloatingActionButton addNewDetails;
    //private RoomDbHelper roomDbHelper;
    private DbHelperParent dbHelperParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomListActivity.this, MainActivity.class));
            }
        });

        binUiWIthComponents();
    }

    private void binUiWIthComponents() {

        setData();

        recyclerRoomListAdapter = new RecyclerRoomListAdapter(roomModelList , this);
        recyclerAdapter.setRoomRecyclerAdapter(recyclerViewMeterList, LinearLayout.VERTICAL,recyclerRoomListAdapter);

        addNewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomListActivity.this, NewRentDetailsActivity.class));
            }
        });
    }

    private void setData() {
        //roomModelList = roomDbHelper.getAllRoomDetails();
        roomModelList = dbHelperParent.getAllRoomDetails();
        if (roomModelList.size()<=0){
            noDataTXT.setVisibility(View.VISIBLE);
            noDataTXT.setText(R.string.no_data_message);
        }
    }

    private void init() {
        recyclerViewMeterList = findViewById(R.id.mRecylerView);
        recyclerAdapter = new RecyclerAdapter(this);
        addNewDetails = findViewById(R.id.mAddRoomMaster);
        roomModelList = new ArrayList<>();
        toolbar = findViewById(R.id.tool_bar);
        //roomDbHelper = new RoomDbHelper(this);
        dbHelperParent = new DbHelperParent(this);
        noDataTXT = findViewById(R.id.mNoDataMessage);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

