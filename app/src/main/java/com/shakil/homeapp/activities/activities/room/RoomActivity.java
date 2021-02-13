package com.shakil.homeapp.activities.activities.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.room.Room;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;
import com.shakil.homeapp.databinding.ActivityAddNewRoomBinding;

public class RoomActivity extends AppCompatActivity {
    private ActivityAddNewRoomBinding activityAddNewRoomBinding;
    private SpinnerData spinnerData;
    private SpinnerAdapter spinnerAdapter;
    private InputValidation inputValidation;
    private DbHelperParent dbHelperParent;
    private String roomNameStr, startMonthStr,associateMeterStr,tenantNameStr;
    private int StartMonthId, AssociateMeterId;
    private int advancedAmountInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddNewRoomBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_room);
        init();
        setSupportActionBar(activityAddNewRoomBinding.toolBar);

        activityAddNewRoomBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bindUIWithComponents();
    }

    private void bindUIWithComponents() {
        spinnerAdapter.setSpinnerAdapter(activityAddNewRoomBinding.StartMonthId,spinnerData.setMonthData(),this);
        spinnerAdapter.setSpinnerAdapter(activityAddNewRoomBinding.AssociateMeterId,spinnerData.setMeterData(),this);

        //region month and meter selection spinner
        activityAddNewRoomBinding.StartMonthId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startMonthStr = parent.getItemAtPosition(position).toString();
                StartMonthId = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        activityAddNewRoomBinding.AssociateMeterId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startMonthStr = parent.getItemAtPosition(position).toString();
                StartMonthId = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        activityAddNewRoomBinding.AdvanceCehckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean visibilityValue) {
                if (visibilityValue){
                    activityAddNewRoomBinding.advanceAmountLayout.setVisibility(View.VISIBLE);
                    if (inputValidation.checkEditTextInput(R.id.AdvanceAmount,"Please give amount")){
                        advancedAmountInt = Integer.parseInt(activityAddNewRoomBinding.AdvanceAmount.getText().toString());
                    }
                    else{
                        Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    activityAddNewRoomBinding.advanceAmountLayout.setVisibility(View.GONE);
                }
            }
        });

        activityAddNewRoomBinding.mSaveRoomMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Room room = new Room();
                inputValidation.checkEditTextInput(new int[]{R.id.RoomName,R.id.TenantName},"Please check your data");

                if (!startMonthStr.equals("Select Data") && !associateMeterStr.equals("Select Data")){
                    roomNameStr = activityAddNewRoomBinding.RoomName.getText().toString();
                    tenantNameStr = activityAddNewRoomBinding.TenantName.getText().toString();
                    room.setRoomName(roomNameStr);
                    room.setStartMonthName(startMonthStr);
                    room.setAssociateMeterName(associateMeterStr);
                    room.setTenantName(tenantNameStr);
                    room.setAdvancedAmount(advancedAmountInt);
                    //roomDbHelper.addRoom(roomModel);
                    dbHelperParent.addRoom(room);
                    Toast.makeText(getApplicationContext(),R.string.success,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RoomActivity.this,RoomListActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        spinnerData = new SpinnerData(this);
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation(this,activityAddNewRoomBinding.mainLayout);
        //roomDbHelper = new RoomDbHelper(this);
        dbHelperParent = new DbHelperParent(this);
    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(RoomActivity.this, RoomListActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelperParent.close();
    }
}
