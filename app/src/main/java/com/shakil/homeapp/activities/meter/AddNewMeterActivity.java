package com.shakil.homeapp.activities.meter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.MeterDbHelper;
import com.shakil.homeapp.activities.model.MeterModel;
import com.shakil.homeapp.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;

public class AddNewMeterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText meterName;
    private Spinner roomSpinner, meterTypeSpinner;
    private InputValidation inputValidation;
    private SpinnerAdapter spinnerAdapter;
    private SpinnerData spinnerData;
    private FloatingActionButton addMeter;
    private LinearLayout linearLayout;
    private MeterDbHelper meterDbHelper;
    private String meterNameStr , roomNameStr , meterTypeStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_meter);

        init();

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNewMeterActivity.this, MainActivity.class));
            }
        });

        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        spinnerAdapter.setSpinnerAdapter(roomSpinner,spinnerData.setRoomData(),this);
        spinnerAdapter.setSpinnerAdapter(meterTypeSpinner,spinnerData.setMeterTypeData(),this);

        addMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputValidation.checkEditTextInput(R.id.MeterName,"Please check your data");

                roomNameStr = inputValidation.checkSpinner(R.id.RoomSpinner);
                meterTypeStr = inputValidation.checkSpinner(R.id.MeterTypeSpinner);

                if (!roomNameStr.equals("Select Data") && !meterTypeStr.equals("Select Data")){
                    meterNameStr = meterName.getText().toString();
                    MeterModel meterModel = new MeterModel();
                    meterModel.setMeterName(meterNameStr);
                    meterModel.setAssociateRoom(roomNameStr);
                    meterModel.setMeterType(meterTypeStr);
                    meterDbHelper.addMeter(meterModel);
                    Toast.makeText(getApplicationContext(),R.string.success,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddNewMeterActivity.this,MeterListActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        meterName = findViewById(R.id.MeterName);
        roomSpinner = findViewById(R.id.RoomSpinner);
        meterTypeSpinner = findViewById(R.id.MeterTypeSpinner);
        addMeter = findViewById(R.id.mSaveMeterMaster);
        linearLayout = findViewById(R.id.mainLayout);

        inputValidation = new InputValidation(this,linearLayout);
        spinnerAdapter = new SpinnerAdapter();
        spinnerData = new SpinnerData();
        meterDbHelper = new MeterDbHelper(this);
    }
}
