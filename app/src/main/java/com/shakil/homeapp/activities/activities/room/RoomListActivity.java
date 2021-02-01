package com.shakil.homeapp.activities.activities.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.meter.NewMeterActivity;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.adapter.RecyclerRoomListAdapter;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.room.Room;
import com.shakil.homeapp.activities.mvvm.RoomModelMVVM;
import com.shakil.homeapp.activities.mvvm.RoomViewModel;
import com.shakil.homeapp.databinding.ActivityRoomListBinding;

import java.util.ArrayList;
import java.util.List;

public class RoomListActivity extends AppCompatActivity {
    private ActivityRoomListBinding activityRoomListBinding;
    private RecyclerRoomListAdapter recyclerRoomListAdapter;
    private TextView noDataTXT;
    private ArrayList<Room> roomList;
    private DbHelperParent dbHelperParent;
    //For MVVM
    private RoomViewModel roomViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRoomListBinding = DataBindingUtil.setContentView(this, R.layout.activity_room_list);

        init();
        setSupportActionBar(activityRoomListBinding.toolBar);

        activityRoomListBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
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
        activityRoomListBinding.mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        activityRoomListBinding.mRecylerView.setAdapter(recyclerRoomListAdapter);
        recyclerRoomListAdapter.notifyDataSetChanged();
        recyclerRoomListAdapter.setOnItemClickListener(new RecyclerRoomListAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Room room) {
                startActivity(new Intent(RoomListActivity.this, NewMeterActivity.class).putExtra("room", room));
            }
        });

        activityRoomListBinding.mAddRoomMaster.setOnClickListener(new View.OnClickListener() {
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
        roomList = dbHelperParent.getAllRoomDetails();
        if (roomList.size()<=0){
            noDataTXT.setVisibility(View.VISIBLE);
            noDataTXT.setText(R.string.no_data_message);
        }
    }

    private void init() {
        roomList = new ArrayList<>();
        dbHelperParent = new DbHelperParent(this);
        noDataTXT = findViewById(R.id.mNoDataMessage);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RoomListActivity.this,MainActivity.class));
    }
}

