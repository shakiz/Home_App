package com.shakil.homeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.room.AddNewRoomActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView addRoom;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNewRoomActivity.class));
            }
        });
    }

    private void init() {
        addRoom = findViewById(R.id.mAddMasterRoom);
        toolbar = findViewById(R.id.tool_bar);
    }
}
