package com.shakil.homeapp.activities.room;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;

public class AddNewRoomActivity extends AppCompatActivity {

    private Spinner monthSpinner;
    private FloatingActionButton addRoomButton;
    private EditText roomName,tenantName,advanceAmount;
    private CheckBox checkBoxAdvance;
    private LinearLayout linearLayoutAdvanceAmount;
    private SpinnerData spinnerData;
    private SpinnerAdapter spinnerAdapter;
    private InputValidation inputValidation;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_room);

        init();
        spinnerAdapter.setSpinnerAdapter(monthSpinner,spinnerData.setMonthData(),this);

        checkBoxAdvance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean visibilityValue) {
                if (visibilityValue){
                    linearLayoutAdvanceAmount.setVisibility(View.VISIBLE);
                }
                else{
                    linearLayoutAdvanceAmount.setVisibility(View.GONE);
                }
            }
        });

        addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputValidation.checkInput(R.id.RoomName,"Please Input Value",mainLayout) && inputValidation.checkInput(R.id.TenantName,"Please Input Value",mainLayout)){

                }
            }
        });
    }

    private void init() {
        monthSpinner = findViewById(R.id.MonthSpinner);
        addRoomButton = findViewById(R.id.mSaveRoomMaster);
        roomName = findViewById(R.id.RoomName);
        tenantName = findViewById(R.id.TenantName);
        advanceAmount = findViewById(R.id.AdvanceAmount);
        checkBoxAdvance = findViewById(R.id.AdvanceCehckBox);
        linearLayoutAdvanceAmount = findViewById(R.id.advanceAmountLayout);
        mainLayout = findViewById(R.id.mainLayout);
        spinnerData = new SpinnerData();
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation();
    }


}
