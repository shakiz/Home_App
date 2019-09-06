package com.shakil.homeapp.activities.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;

public class NewRentDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Spinner monthSpinner, roomSpinner;
    private FloatingActionButton addRentButton;
    private EditText rentAmount;
    private LinearLayout mainLayout;
    private SpinnerData spinnerData;
    private InputValidation inputValidation;
    private SpinnerAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_rent_details);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewRentDetailsActivity.this,RoomListActivity.class));
            }
        });
        bindUiWithComponents();
    }
    private void bindUiWithComponents() {
        spinnerAdapter.setSpinnerAdapter(monthSpinner,spinnerData.setMonthData(),this);
        spinnerAdapter.setSpinnerAdapter(roomSpinner,spinnerData.setRoomData(),this);

        addRentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValidation.checkEditTextInput(R.id.RentAmount,"Please check your value",mainLayout);
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        monthSpinner = findViewById(R.id.MonthSpinner);
        roomSpinner = findViewById(R.id.RoomSpinner);
        addRentButton = findViewById(R.id.mAddRentMaster);
        rentAmount = findViewById(R.id.RentAmount);
        mainLayout = findViewById(R.id.mainLayout);
        spinnerData = new SpinnerData();
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation(this);
    }
}
