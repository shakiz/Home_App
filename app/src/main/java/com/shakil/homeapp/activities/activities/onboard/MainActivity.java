package com.shakil.homeapp.activities.activities.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.meter.MeterCostDetailsActivity;
import com.shakil.homeapp.activities.activities.meter.MeterListActivity;
import com.shakil.homeapp.activities.activities.room.NewRentDetailsActivity;
import com.shakil.homeapp.activities.activities.room.RoomListActivity;
import com.shakil.homeapp.activities.activities.tenant.TenantListActivity;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.utils.UtilsForAll;
import com.shakil.homeapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding activityMainBinding;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private DbHelperParent dbHelperParent;
    private Toolbar toolbar;
    private UtilsForAll utilsForAll;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();


        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        toggle = new ActionBarDrawerToggle(
                this, activityMainBinding.drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityMainBinding.drawerLayout.addDrawerListener(toggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        bindUIWithComponents();
    }

    private void bindUIWithComponents() {

        setData();

        activityMainBinding.mAddMasterRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewRentDetailsActivity.class));
            }
        });

        activityMainBinding.mAddMasterElectricityBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MeterCostDetailsActivity.class));
            }
        });

        activityMainBinding.meterDashboardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MeterListActivity.class));
            }
        });

        activityMainBinding.roomDashboardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RoomListActivity.class));
            }
        });

        activityMainBinding.tenantDashboardCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TenantListActivity.class));
            }
        });
    }

    private void setData() {
        activityMainBinding.totalRooms.setText(getString(R.string.total_rooms)+" : "+dbHelperParent.getTotalRoomRows());
        activityMainBinding.totalMeters.setText(getString(R.string.total_meters)+" : "+dbHelperParent.getTotalMeterRows());
        utilsForAll.setCustomDesignTextView(R.id.totalRooms);
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        mainLayout = findViewById(R.id.mainLayout);
        dbHelperParent = new DbHelperParent(this);
        utilsForAll = new UtilsForAll(this,mainLayout);
        navigationView = findViewById(R.id.nav_view);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handling navigation view item clicks based on their respective ids.
        int id = item.getItemId();

        activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (activityMainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            utilsForAll.exitApp();
        }
    }
}
