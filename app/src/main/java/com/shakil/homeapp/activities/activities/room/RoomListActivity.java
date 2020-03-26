package com.shakil.homeapp.activities.activities.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.adapter.RecyclerRoomListAdapter;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.room.Room;
import com.shakil.homeapp.activities.mvvm.RoomModelMVVM;
import com.shakil.homeapp.activities.mvvm.RoomViewModel;
import com.shakil.homeapp.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.RecyclerAdapter;
import java.util.ArrayList;
import java.util.List;

public class RoomListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMeterList;
    private RecyclerRoomListAdapter recyclerRoomListAdapter;
    private RecyclerAdapter recyclerAdapter;
    private TextView noDataTXT;
    private ArrayList<Room> roomList;
    private Toolbar toolbar;
    private FloatingActionButton addNewDetails;
    //private RoomDbHelper roomDbHelper;
    private DbHelperParent dbHelperParent;
    //For MVVM
    private RoomViewModel roomViewModel;

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

        recyclerRoomListAdapter = new RecyclerRoomListAdapter(roomList, this);
        recyclerAdapter.setRoomRecyclerAdapter(recyclerViewMeterList, LinearLayout.VERTICAL,recyclerRoomListAdapter);

        addNewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomListActivity.this, AddNewRoomActivity.class));
            }
        });

        //MVVM region

        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);
        roomViewModel.getAllRoomData().observe(this, new Observer<List<RoomModelMVVM>>() {
            @Override
            public void onChanged(List<RoomModelMVVM> roomModelMVVMS) {
                Toast.makeText(getApplicationContext(),"called",Toast.LENGTH_LONG).show();
            }
        });

        //region end
    }

    private void setData() {
        //roomModelList = roomDbHelper.getAllRoomDetails();
        roomList = dbHelperParent.getAllRoomDetails();
        if (roomList.size()<=0){
            noDataTXT.setVisibility(View.VISIBLE);
            noDataTXT.setText(R.string.no_data_message);
        }
    }

    private void init() {
        recyclerViewMeterList = findViewById(R.id.mRecylerView);
        recyclerAdapter = new RecyclerAdapter(this);
        addNewDetails = findViewById(R.id.mAddRoomMaster);
        roomList = new ArrayList<>();
        toolbar = findViewById(R.id.tool_bar);
        //roomDbHelper = new RoomDbHelper(this);
        dbHelperParent = new DbHelperParent(this);
        noDataTXT = findViewById(R.id.mNoDataMessage);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RoomListActivity.this,MainActivity.class));
    }
}

