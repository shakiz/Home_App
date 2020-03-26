package com.shakil.homeapp.activities.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.activities.meter.MeterListActivity;
import com.shakil.homeapp.activities.activities.meter.NewMeterDetailsActivity;
import com.shakil.homeapp.activities.activities.room.NewRentDetailsActivity;
import com.shakil.homeapp.activities.activities.room.RoomListActivity;
import com.shakil.homeapp.activities.activities.tenant.TenantListActivity;
import com.shakil.homeapp.activities.utils.UtilsForAll;

public class MainActivity extends AppCompatActivity {

    private ImageView addRoom , addMeter;
    private TextView totalRoomsTXT ,  totalEarningsTXT;
    private DbHelperParent dbHelperParent;
    private Toolbar toolbar;
    private CardView meterCard,roomCard,tenantCard;
    private UtilsForAll utilsForAll;
    private LinearLayout mainLayout;

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

        setData();

        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewRentDetailsActivity.class));
            }
        });

        addMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewMeterDetailsActivity.class));
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

        tenantCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TenantListActivity.class));
            }
        });
    }

    private void setData() {
        totalRoomsTXT.setText("Total rooms : "+dbHelperParent.getTotalRoomRows());
        utilsForAll.setCustomDesignTextView(R.id.totalRooms);
    }

    private void init() {
        addRoom = findViewById(R.id.mAddMasterRoom);
        addMeter = findViewById(R.id.mAddMasterElectricityBill);
        toolbar = findViewById(R.id.tool_bar);
        totalRoomsTXT = findViewById(R.id.totalRooms);
        totalEarningsTXT = findViewById(R.id.totalEarnings);
        meterCard = findViewById(R.id.meterDashboardCard);
        roomCard = findViewById(R.id.roomDashboardCard);
        tenantCard = findViewById(R.id.tenantDashboardCard);
        mainLayout = findViewById(R.id.mainLayout);
        dbHelperParent = new DbHelperParent(this);
        utilsForAll = new UtilsForAll(this,mainLayout);
    }

    @Override
    public void onBackPressed() {
        utilsForAll.exitApp();
    }
}
