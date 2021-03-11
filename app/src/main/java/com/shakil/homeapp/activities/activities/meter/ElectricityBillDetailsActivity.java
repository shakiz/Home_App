package com.shakil.homeapp.activities.activities.meter;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.dbhelper.DbHelperParent;
import com.shakil.homeapp.activities.model.meter.ElectricityBill;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;
import com.shakil.homeapp.activities.utils.UtilsForAll;
import com.shakil.homeapp.databinding.ActivityElectricityBillDetailsBinding;

public class ElectricityBillDetailsActivity extends AppCompatActivity {
    private ActivityElectricityBillDetailsBinding activityMeterCostDetailsBinding;
    private String meterNameStr, roomNameStr;
    private int totalUnitInt, previousMonthUnitInt, presentMonthUnitInt, unitPriceInt, totalElectricityBillInt;
    private SpinnerData spinnerData;
    private SpinnerAdapter spinnerAdapter;
    private InputValidation inputValidation;
    private UtilsForAll utilsForAll;
    private DbHelperParent dbHelperParent;
    private ElectricityBill electricityBill = new ElectricityBill();
    private String command = "add";
    private int AssociateMeterId, AssociateRoomId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMeterCostDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_electricity_bill_details);

        //region get intent data
        getIntentData();
        //endregion

        init();
        setSupportActionBar(activityMeterCostDetailsBinding.toolBar);

        activityMeterCostDetailsBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        bindUiWithComponents();

        //region load intent data to UI
        loadData();
        //endregion
    }

    //region get intent data
    private void getIntentData(){
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getParcelable("electricityBill") != null){
                electricityBill = getIntent().getExtras().getParcelable("electricityBill");
            }
        }
    }
    //endregion

    //region load intent data to UI
    private void loadData(){
        if (electricityBill.getBillId() != 0) {
            command = "update";
            activityMeterCostDetailsBinding.UnitPrice.setText(String.valueOf(electricityBill.getUnitPrice()));
            activityMeterCostDetailsBinding.PresentUnit.setText(String.valueOf(electricityBill.getPresentUnit()));
            activityMeterCostDetailsBinding.PastUnit.setText(String.valueOf(electricityBill.getPastUnit()));
            activityMeterCostDetailsBinding.TotalUnit.setText(String.valueOf(electricityBill.getTotalUnit()));
            activityMeterCostDetailsBinding.TotalAmount.setText(String.valueOf(electricityBill.getTotalUnit() * electricityBill.getUnitPrice()));
        }
    }
    //endregion

    private void bindUiWithComponents() {
        //region room name select spinner
        activityMeterCostDetailsBinding.AssociateMeterId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                meterNameStr = parent.getItemAtPosition(position).toString();
                AssociateMeterId = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        activityMeterCostDetailsBinding.AssociateRoomId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                roomNameStr = parent.getItemAtPosition(position).toString();
                AssociateRoomId = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        spinnerAdapter.setSpinnerAdapter(activityMeterCostDetailsBinding.AssociateMeterId,spinnerData.setMeterData(),this);
        spinnerAdapter.setSpinnerAdapter(activityMeterCostDetailsBinding.AssociateRoomId,spinnerData.setRoomData(),this);

        //region Adding new details
        activityMeterCostDetailsBinding.mAddMeterDetailsMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValidation.checkEditTextInput(new int[]{R.id.PresentUnit,R.id.PastUnit,R.id.UnitPrice},"Please check your value");
                if (!meterNameStr.equals("Select Data") && !roomNameStr.equals("Select Data")){
                    electricityBill.setMeterId(AssociateMeterId);
                    electricityBill.setRoomId(AssociateRoomId);
                    electricityBill.setMeterName(meterNameStr);
                    electricityBill.setRoomName(roomNameStr);
                    electricityBill.setUnitPrice(Integer.parseInt(activityMeterCostDetailsBinding.UnitPrice.getText().toString()));
                    electricityBill.setPresentUnit(Integer.parseInt(activityMeterCostDetailsBinding.PresentUnit.getText().toString()));
                    electricityBill.setPastUnit(Integer.parseInt(activityMeterCostDetailsBinding.PastUnit.getText().toString()));
                    electricityBill.setTotalUnit(Integer.parseInt(activityMeterCostDetailsBinding.TotalUnit.getText().toString()));
                    electricityBill.setTotalBill(Integer.parseInt(activityMeterCostDetailsBinding.TotalUnit.getText().toString()));

                    if (command.equals("add")){
                        dbHelperParent.addElectricityBill(electricityBill);
                    }
                    else if (command.equals("update")){
                        dbHelperParent.updateElectricityBill(electricityBill, electricityBill.getBillId());
                    }
                    Toast.makeText(getApplicationContext(),R.string.success,Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ElectricityBillDetailsActivity.this, ElectricityBillListActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.warning_message,Toast.LENGTH_SHORT).show();
                }
            }
        });
        //region end

        //region present month unit on change
        activityMeterCostDetailsBinding.PastUnit.addTextChangedListener(new TextWatcher() {
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
        activityMeterCostDetailsBinding.PresentUnit.addTextChangedListener(new TextWatcher() {
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
                activityMeterCostDetailsBinding.TotalAmount.setText(String.valueOf(totalElectricityBillInt));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private int calculateUnit(int previousMonthUnitValue , int presentMonthUnitValue){
        if (presentMonthUnitValue >0 ){
            totalUnitInt = previousMonthUnitValue - presentMonthUnitValue;
            activityMeterCostDetailsBinding.TotalUnit.setText(String.valueOf(totalUnitInt));
            activityMeterCostDetailsBinding.TotalUnit.setTextColor(getResources().getColor(R.color.md_grey_800));
        }
        else {
            Toast.makeText(getApplicationContext(),"Please check unit value",Toast.LENGTH_SHORT).show();
            totalUnitInt = 0;
            activityMeterCostDetailsBinding.TotalUnit.setText(String.valueOf(totalUnitInt));
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
            activityMeterCostDetailsBinding.TotalUnit.setText(String.valueOf(totalUnitInt));
            activityMeterCostDetailsBinding.TotalUnit.setTextColor(getResources().getColor(R.color.md_red_400));
        }
    }


    private void init() {
        spinnerData = new SpinnerData(this);
        spinnerAdapter = new SpinnerAdapter();
        dbHelperParent = new DbHelperParent(this);
        inputValidation = new InputValidation(this,activityMeterCostDetailsBinding.mainLayout);
        utilsForAll = new UtilsForAll(this,activityMeterCostDetailsBinding.mainLayout);
    }

    //region activity components
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelperParent.close();
    }

    //endregion
}
