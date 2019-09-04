package com.shakil.homeapp.activities.meter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import com.shakil.homeapp.R;

public class NewMeterDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meter_details);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bindUiWithComponents();
    }

    private void bindUiWithComponents() {
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
    }
}
