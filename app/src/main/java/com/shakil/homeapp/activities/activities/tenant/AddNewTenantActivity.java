package com.shakil.homeapp.activities.activities.tenant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.tenant.Tenant;
import com.shakil.homeapp.activities.onboard.MainActivity;

import java.util.ArrayList;

public class AddNewTenantActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton actionButton;
    private LinearLayout mainLayout;
    private ArrayList<Tenant> tenantList;
    private DbHelperParent dbHelperParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_tenant);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNewTenantActivity.this, TenantListActivity.class));
            }
        });


        bindUiWithComponents();
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        actionButton = findViewById(R.id.mSaveTenantMaster);
        mainLayout = findViewById(R.id.mainLayout);
        tenantList = new ArrayList<>();
        dbHelperParent = new DbHelperParent(this);
    }

    private void bindUiWithComponents(){
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddNewTenantActivity.this,TenantListActivity.class));
            }
        });
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(AddNewTenantActivity.this, MainActivity.class));
    }
}
