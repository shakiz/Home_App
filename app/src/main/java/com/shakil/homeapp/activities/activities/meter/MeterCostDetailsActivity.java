package com.shakil.homeapp.activities.activities.meter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.model.meter.Meter;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;
import com.shakil.homeapp.activities.utils.UtilsForAll;
import com.shakil.homeapp.databinding.ActivityMeterCostDetailsBinding;

public class MeterCostDetailsActivity extends AppCompatActivity {
    private ActivityMeterCostDetailsBinding activityMeterCostDetailsBinding;
    private String meterNameStr, roomNameStr;
    private int totalUnitInt, previousMonthUnitInt, presentMonthUnitInt, unitPriceInt, totalElectricityBillInt;
    private SpinnerData spinnerData;
    private SpinnerAdapter spinnerAdapter;
    private InputValidation inputValidation;
    private UtilsForAll utilsForAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMeterCostDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_meter_cost_details);

        init();
        setSupportActionBar(activityMeterCostDetailsBinding.toolBar);

        activityMeterCostDetailsBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeterCostDetailsActivity.this, MainActivity.class));
            }
        });
        bindUiWithComponents();
    }

    private void bindUiWithComponents() {
        spinnerAdapter.setSpinnerAdapter(activityMeterCostDetailsBinding.MeterSpinner,spinnerData.setMeterData(),this);
        spinnerAdapter.setSpinnerAdapter(activityMeterCostDetailsBinding.RoomSpinner,spinnerData.setRoomData(),this);

        //region Adding new details
        activityMeterCostDetailsBinding.mAddMeterDetailsMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meterNameStr = inputValidation.checkSpinner(R.id.MeterSpinner);
                roomNameStr = inputValidation.checkSpinner(R.id.RoomSpinner);
                inputValidation.checkEditTextInput(new int[]{R.id.PresentMonthUnit,R.id.PreviousMonthUnit,R.id.UnitPrice},"Please check your value");
                if (!meterNameStr.equals("Select Data") && !roomNameStr.equals("Select Data")){
                    Meter meter = new Meter(meterNameStr,roomNameStr,"","",presentMonthUnitInt,previousMonthUnitInt);
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                }
            }
        });
        //region end

        //region present month unit on change
        activityMeterCostDetailsBinding.PreviousMonthUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                previousMonthUnitInt = utilsForAll.toIntValue(charSequence.toString());
                Log.v("shakil","previousMonthUnitInt : "+previousMonthUnitInt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //region end

        //region previous month unit on change
        activityMeterCostDetailsBinding.PresentMonthUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presentMonthUnitInt = utilsForAll.toIntValue(charSequence.toString());
                checkUnitLimit(previousMonthUnitInt,presentMonthUnitInt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //region end

        //region unit price on change
        activityMeterCostDetailsBinding.UnitPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                unitPriceInt = utilsForAll.toIntValue(charSequence.toString());
                totalElectricityBillInt = unitPriceInt*totalUnitInt;
                activityMeterCostDetailsBinding.TotalAmount.setText("Total Electricity Bill "+ totalElectricityBillInt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private int calculateUnit(int previousMonthUnitValue , int presentMonthUnitValue){
        if (presentMonthUnitValue >0 ){
            totalUnitInt = previousMonthUnitValue - presentMonthUnitValue;
            activityMeterCostDetailsBinding.TotalUnit.setText("Total Unit "+totalUnitInt);
            activityMeterCostDetailsBinding.TotalUnit.setTextColor(getResources().getColor(R.color.md_grey_800));
        }
        else {
            Toast.makeText(getApplicationContext(),"Please check unit value",Toast.LENGTH_SHORT).show();
            totalUnitInt = 0;
            activityMeterCostDetailsBinding.TotalUnit.setText("Total Unit "+totalUnitInt);
            activityMeterCostDetailsBinding.TotalUnit.setTextColor(getResources().getColor(R.color.md_red_400));
        }
        return totalUnitInt;
    }

    private void checkUnitLimit(int previousMonthUnitValue , int presentMonthUnitValue){
        if (previousMonthUnitValue>presentMonthUnitValue) {
            calculateUnit(previousMonthUnitValue, presentMonthUnitValue);
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.warning_message_unit, Toast.LENGTH_SHORT).show();
            totalUnitInt = 0;
            activityMeterCostDetailsBinding.TotalUnit.setText("Total Unit "+totalUnitInt);
            activityMeterCostDetailsBinding.TotalUnit.setTextColor(getResources().getColor(R.color.md_red_400));
        }
    }


    private void init() {
        spinnerData = new SpinnerData(this);
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation(this,activityMeterCostDetailsBinding.mainLayout);
        utilsForAll = new UtilsForAll(this,activityMeterCostDetailsBinding.mainLayout);
    }
}
