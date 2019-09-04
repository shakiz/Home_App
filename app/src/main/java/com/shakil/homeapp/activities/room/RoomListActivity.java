package com.shakil.homeapp.activities.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.adapter.RecyclerRoomListAdapter;
import com.shakil.homeapp.activities.model.RoomModel;
import com.shakil.homeapp.activities.utils.RecyclerAdapter;
import java.util.ArrayList;

public class RoomListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMeterList;
    private RecyclerRoomListAdapter recyclerRoomListAdapter;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<RoomModel> roomModelList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

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

        recyclerRoomListAdapter = new RecyclerRoomListAdapter(roomModelList , this);
        recyclerAdapter.setRoomRecyclerAdapter(recyclerViewMeterList, LinearLayout.VERTICAL,recyclerRoomListAdapter);
    }

    private void setData() {
        roomModelList.add(new RoomModel("Room 1","David","12 June, 2019","1 Jul,2019"));
        roomModelList.add(new RoomModel("Room 1","David","12 June, 2019","1 Jul,2019"));
        roomModelList.add(new RoomModel("Room 1","David","12 June, 2019","1 Jul,2019"));
        roomModelList.add(new RoomModel("Room 1","David","12 June, 2019","1 Jul,2019"));
        roomModelList.add(new RoomModel("Room 1","David","12 June, 2019","1 Jul,2019"));
        roomModelList.add(new RoomModel("Room 1","David","12 June, 2019","1 Jul,2019"));
    }

    private void init() {
        recyclerViewMeterList = findViewById(R.id.mRecylerView);
        recyclerAdapter = new RecyclerAdapter(this);
        roomModelList = new ArrayList<>();
        toolbar = findViewById(R.id.tool_bar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

