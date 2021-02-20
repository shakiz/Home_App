package com.shakil.homeapp.activities.activities.onboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.navigation.NavigationView;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.meter.ElectricityBillListActivity;
import com.shakil.homeapp.activities.activities.meter.MeterListActivity;
import com.shakil.homeapp.activities.activities.room.RentListActivity;
import com.shakil.homeapp.activities.activities.room.RoomListActivity;
import com.shakil.homeapp.activities.activities.tenant.NewTenantActivity;
import com.shakil.homeapp.activities.activities.tenant.TenantListActivity;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.utils.UtilsForAll;
import com.shakil.homeapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding activityMainBinding;
    private ActionBarDrawerToggle toggle;
    private DbHelperParent dbHelperParent;
    private UtilsForAll utilsForAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();

        setSupportActionBar(activityMainBinding.toolBar);
        activityMainBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activityMainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    activityMainBinding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        toggle = new ActionBarDrawerToggle(
                this, activityMainBinding.drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityMainBinding.drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        activityMainBinding.navView.setNavigationItemSelectedListener(this);

        bindUIWithComponents();
    }

    //region UI interactions
    private void bindUIWithComponents() {

        setData();

        activityMainBinding.mAddMasterRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RentListActivity.class));
            }
        });

        activityMainBinding.mAddMasterElectricityBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ElectricityBillListActivity.class));
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
                startActivity(new Intent(MainActivity.this, NewTenantActivity.class));
            }
        });
    }
    //endregion

    private void setData() {
        activityMainBinding.totalRooms.setText(getString(R.string.total_rooms)+" : "+dbHelperParent.getTotalRoomRows());
        activityMainBinding.totalMeters.setText(getString(R.string.total_meters)+" : "+dbHelperParent.getTotalMeterRows());
        utilsForAll.setCustomDesignTextView(R.id.totalRooms);
    }

    //region init components
    private void init() {
        dbHelperParent = new DbHelperParent(this);
        utilsForAll = new UtilsForAll(this,activityMainBinding.mainLayout);
    }
    //endregion

    //region activity components
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handling navigation view item clicks based on their respective ids.
        int id = item.getItemId();
        if (id == R.id.nav_meter_list){
            startActivity(new Intent(MainActivity.this, MeterListActivity.class));
        }
        else if (id == R.id.nav_room_list){
            startActivity(new Intent(MainActivity.this, RoomListActivity.class));
        }
        else if (id == R.id.nav_tenant_list){
            startActivity(new Intent(MainActivity.this, TenantListActivity.class));
        }
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
    //endregion
}
