package com.shakil.homeapp.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.meter.AddNewMeterActivity;
import com.shakil.homeapp.activities.meter.MeterListActivity;
import com.shakil.homeapp.activities.room.AddNewRoomActivity;
import com.shakil.homeapp.activities.room.RoomListActivity;
import com.shakil.homeapp.activities.utils.UtilsForAll;

public class MainActivity extends AppCompatActivity {

    private ImageView addRoom , addMeter;
    private Toolbar toolbar;
    private CardView meterCard,roomCard;
    private UtilsForAll utilsForAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilsForAll.exitApp();
            }
        });

        bindUIWithComponents();
    }

    private void bindUIWithComponents() {

        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNewRoomActivity.class));
            }
        });

        addMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNewMeterActivity.class));
            }
        });

        meterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MeterListActivity.class));
            }
        });

        roomCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RoomListActivity.class));
            }
        });
    }

    private void init() {
        addRoom = findViewById(R.id.mAddMasterRoom);
        addMeter = findViewById(R.id.mAddMasterElectricityBill);
        toolbar = findViewById(R.id.tool_bar);
        meterCard = findViewById(R.id.meterDashboardCard);
        roomCard = findViewById(R.id.roomDashboardCard);
        utilsForAll = new UtilsForAll(this);
    }

    @Override
    public void onBackPressed() {
        utilsForAll.exitApp();
    }
}
