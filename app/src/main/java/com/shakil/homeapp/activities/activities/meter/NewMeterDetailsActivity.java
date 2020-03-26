package com.shakil.homeapp.activities.activities.meter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.model.meter.Meter;
import com.shakil.homeapp.activities.onboard.MainActivity;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;
import com.shakil.homeapp.activities.utils.UtilsForAll;

public class NewMeterDetailsActivity extends AppCompatActivity {

    private Spinner meterSpinner,roomSpinner;
    private TextView totalUnitTXT , totalPriceTXT;
    private EditText unitPrice, presentMonthUnit , previousMonthUnit;
    private FloatingActionButton addMeterDetails;
    private Toolbar toolbar;
    private String meterNameStr, roomNameStr;
    private int totalUnitInt , previousMonthUnitInt , presentMonthUnitInt , unitPriceInt , totalElectricityBillInt;
    private LinearLayout mainLayout;
    private SpinnerData spinnerData;
    private SpinnerAdapter spinnerAdapter;
    private InputValidation inputValidation;
    private UtilsForAll utilsForAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meter_details);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewMeterDetailsActivity.this, MainActivity.class));
            }
        });
        bindUiWithComponents();
    }

    private void bindUiWithComponents() {
        spinnerAdapter.setSpinnerAdapter(meterSpinner,spinnerData.setMeterData(),this);
        spinnerAdapter.setSpinnerAdapter(roomSpinner,spinnerData.setRoomData(),this);

        //region Adding new details
        addMeterDetails.setOnClickListener(new View.OnClickListener() {
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
        previousMonthUnit.addTextChangedListener(new TextWatcher() {
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
        presentMonthUnit.addTextChangedListener(new TextWatcher() {
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
        unitPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                unitPriceInt = utilsForAll.toIntValue(charSequence.toString());
                totalElectricityBillInt = unitPriceInt*totalUnitInt;
                totalPriceTXT.setText("Total Electricity Bill "+ totalElectricityBillInt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private int calculateUnit(int previousMonthUnitValue , int presentMonthUnitValue){
        if (presentMonthUnitValue >0 ){
            totalUnitInt = previousMonthUnitValue - presentMonthUnitValue;
            totalUnitTXT.setText("Total Unit "+totalUnitInt);
            totalUnitTXT.setTextColor(getResources().getColor(R.color.md_grey_800));
        }
        else {
            Toast.makeText(getApplicationContext(),"Please check unit value",Toast.LENGTH_SHORT).show();
            totalUnitInt = 0;
            totalUnitTXT.setText("Total Unit "+totalUnitInt);
            totalUnitTXT.setTextColor(getResources().getColor(R.color.md_red_400));
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
            totalUnitTXT.setText("Total Unit "+totalUnitInt);
            totalUnitTXT.setTextColor(getResources().getColor(R.color.md_red_400));
        }
    }


    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        meterSpinner = findViewById(R.id.MeterSpinner);
        roomSpinner = findViewById(R.id.RoomSpinner);
        addMeterDetails = findViewById(R.id.mAddMeterDetailsMaster);
        totalUnitTXT = findViewById(R.id.TotalUnit);
        mainLayout = findViewById(R.id.mainLayout);
        totalPriceTXT = findViewById(R.id.TotalAmount);
        unitPrice = findViewById(R.id.UnitPrice);
        presentMonthUnit = findViewById(R.id.PresentMonthUnit);
        previousMonthUnit = findViewById(R.id.PreviousMonthUnit);
        spinnerData = new SpinnerData(this);
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation(this,mainLayout);
        utilsForAll = new UtilsForAll(this,mainLayout);
    }
}
