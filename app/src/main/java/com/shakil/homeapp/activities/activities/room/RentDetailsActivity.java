package com.shakil.homeapp.activities.activities.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;
import com.shakil.homeapp.databinding.ActivityNewRentDetailsBinding;

public class RentDetailsActivity extends AppCompatActivity {
    private ActivityNewRentDetailsBinding activityNewRentDetailsBinding;
    private SpinnerData spinnerData;
    private InputValidation inputValidation;
    private SpinnerAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNewRentDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_rent_details);

        init();
        setSupportActionBar(activityNewRentDetailsBinding.toolBar);

        activityNewRentDetailsBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RentDetailsActivity.this, MainActivity.class));
            }
        });
        bindUiWithComponents();
    }
    private void bindUiWithComponents() {
        spinnerAdapter.setSpinnerAdapter(activityNewRentDetailsBinding.MonthId,spinnerData.setMonthData(),this);
        spinnerAdapter.setSpinnerAdapter(activityNewRentDetailsBinding.AssociateRoomId,spinnerData.setRoomData(),this);

        activityNewRentDetailsBinding.mAddRentMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValidation.checkEditTextInput(R.id.RentAmount,"Please check your value");
            }
        });
    }

    private void init() {
        spinnerData = new SpinnerData(this);
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation(this, activityNewRentDetailsBinding.mainLayout);
    }
}
