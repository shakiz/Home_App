package com.shakil.homeapp.activities.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.RoomModel;
import com.shakil.homeapp.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;

public class AddNewRoomActivity extends AppCompatActivity {

    private Spinner monthSpinner, meterSpinner;
    private FloatingActionButton addRoomButton;
    private EditText roomName,tenantName,advanceAmount;
    private CheckBox checkBoxAdvance;
    private LinearLayout linearLayoutAdvanceAmount;
    private SpinnerData spinnerData;
    private SpinnerAdapter spinnerAdapter;
    private InputValidation inputValidation;
    private LinearLayout mainLayout;
    private Toolbar toolbar;
    //private RoomDbHelper roomDbHelper;
    private DbHelperParent dbHelperParent;
    private String roomNameStr,startingMonthStr,associateMeterStr,tenantNameStr;
    private int advancedAmountInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_room);
        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNewRoomActivity.this,MainActivity.class));
            }
        });

        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        spinnerAdapter.setSpinnerAdapter(monthSpinner,spinnerData.setMonthData(),this);
        spinnerAdapter.setSpinnerAdapter(meterSpinner,spinnerData.setMeterData(),this);

        checkBoxAdvance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean visibilityValue) {
                if (visibilityValue){
                    linearLayoutAdvanceAmount.setVisibility(View.VISIBLE);
                    if (inputValidation.checkEditTextInput(R.id.AdvanceAmount,"Please give amount")){
                        advancedAmountInt = Integer.parseInt(advanceAmount.getText().toString());
                    }
                    else{
                        Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    linearLayoutAdvanceAmount.setVisibility(View.GONE);
                }
            }
        });

        addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomModel roomModel = new RoomModel();
                inputValidation.checkEditTextInput(new int[]{R.id.RoomName,R.id.TenantName},"Please check your data");
                startingMonthStr = inputValidation.checkSpinner(R.id.MonthSpinner);
                associateMeterStr = inputValidation.checkSpinner(R.id.MeterSpinner);

                if (!startingMonthStr.equals("Select Data") && !associateMeterStr.equals("Select Data")){
                    roomNameStr = roomName.getText().toString();
                    tenantNameStr = tenantName.getText().toString();
                    roomModel.setRoomName(roomNameStr);
                    roomModel.setStartMonth(startingMonthStr);
                    roomModel.setAssociateMeter(associateMeterStr);
                    roomModel.setTenantName(tenantNameStr);
                    roomModel.setAdvancedAmount(advancedAmountInt);
                    //roomDbHelper.addRoom(roomModel);
                    dbHelperParent.addRoom(roomModel);
                    Toast.makeText(getApplicationContext(),R.string.success,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddNewRoomActivity.this,RoomListActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        monthSpinner = findViewById(R.id.MonthSpinner);
        meterSpinner = findViewById(R.id.MeterSpinner);
        addRoomButton = findViewById(R.id.mSaveRoomMaster);
        roomName = findViewById(R.id.RoomName);
        tenantName = findViewById(R.id.TenantName);
        advanceAmount = findViewById(R.id.AdvanceAmount);
        checkBoxAdvance = findViewById(R.id.AdvanceCehckBox);
        linearLayoutAdvanceAmount = findViewById(R.id.advanceAmountLayout);
        mainLayout = findViewById(R.id.mainLayout);
        toolbar = findViewById(R.id.tool_bar);
        spinnerData = new SpinnerData(this);
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation(this,mainLayout);
        //roomDbHelper = new RoomDbHelper(this);
        dbHelperParent = new DbHelperParent(this);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(AddNewRoomActivity.this, MainActivity.class));
    }
}
