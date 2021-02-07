package com.shakil.homeapp.activities.activities.meter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.meter.Meter;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;
import com.shakil.homeapp.databinding.ActivityNewMeterBinding;

public class NewMeterActivity extends AppCompatActivity {
    private ActivityNewMeterBinding activityNewMeterBinding;
    private InputValidation inputValidation;
    private SpinnerAdapter spinnerAdapter;
    private SpinnerData spinnerData;
    private DbHelperParent dbHelperParent;
    private String meterNameStr, roomNameStr, meterTypeStr;
    private Meter meter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNewMeterBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_meter);

        //region get intent data
        //getIntentData();
        //endregion

        init();

        setSupportActionBar(activityNewMeterBinding.toolBar);

        activityNewMeterBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bindUIWithComponents();
    }

    //region get intent data
    private void getIntentData(){
        if (getIntent().getExtras().getParcelable("meter") != null){
            meter = getIntent().getExtras().getParcelable("meter");
        }
    }
    //endregion

    private void bindUIWithComponents() {
        spinnerAdapter.setSpinnerAdapter(activityNewMeterBinding.RoomSpinner,spinnerData.setRoomData(),this);
        spinnerAdapter.setSpinnerAdapter(activityNewMeterBinding.MeterTypeSpinner,spinnerData.setMeterTypeData(),this);

        activityNewMeterBinding.mSaveMeterMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputValidation.checkEditTextInput(R.id.MeterName,"Please check your data");

                roomNameStr = inputValidation.checkSpinner(R.id.RoomSpinner);
                meterTypeStr = inputValidation.checkSpinner(R.id.MeterTypeSpinner);

                if (!roomNameStr.equals("Select Data") && !meterTypeStr.equals("Select Data")){
                    meterNameStr = activityNewMeterBinding.MeterName.getText().toString();
                    Meter meter = new Meter();
                    meter.setMeterName(meterNameStr);
                    meter.setAssociateRoom(roomNameStr);
                    meter.setMeterType(meterTypeStr);
                    dbHelperParent.addMeter(meter);
                    Toast.makeText(getApplicationContext(),R.string.success,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(NewMeterActivity.this,MeterListActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        inputValidation = new InputValidation(this,activityNewMeterBinding.mainLayout);
        spinnerAdapter = new SpinnerAdapter();
        spinnerData = new SpinnerData(this);
        dbHelperParent = new DbHelperParent(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelperParent.close();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(NewMeterActivity.this, MeterListActivity.class));
    }
}
