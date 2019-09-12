package com.shakil.homeapp.activities.meter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shakil.homeapp.R;
import com.shakil.homeapp.activities.utils.InputValidation;
import com.shakil.homeapp.activities.utils.SpinnerAdapter;
import com.shakil.homeapp.activities.utils.SpinnerData;

public class NewMeterDetailsActivity extends AppCompatActivity {

    private Spinner meterSpinner;
    private TextView totalUnitTXT , totalPriceTXT;
    private EditText unitPrice, presentMonthUnit , previousMonthUnit;
    private FloatingActionButton addMeterDetails;
    private Toolbar toolbar;
    private LinearLayout mainLayout;
    private SpinnerData spinnerData;
    private SpinnerAdapter spinnerAdapter;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meter_details);

        init();
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bindUiWithComponents();
    }

    private void bindUiWithComponents() {
        spinnerAdapter.setSpinnerAdapter(meterSpinner,spinnerData.setMeterData(),this);

        addMeterDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputValidation.checkEditTextInput(new int[]{R.id.PresentMonthUnit,R.id.UnitPrice},"Please check your value");
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.tool_bar);
        meterSpinner = findViewById(R.id.MeterSpinner);
        addMeterDetails = findViewById(R.id.mAddMeterDetailsMaster);
        totalUnitTXT = findViewById(R.id.TotalUnit);
        mainLayout = findViewById(R.id.mainLayout);
        totalPriceTXT = findViewById(R.id.TotalAmount);
        unitPrice = findViewById(R.id.UnitPrice);
        presentMonthUnit = findViewById(R.id.PresentMonthUnit);
        previousMonthUnit = findViewById(R.id.PreviousMonthUnit);
        spinnerData = new SpinnerData();
        spinnerAdapter = new SpinnerAdapter();
        inputValidation = new InputValidation(this,mainLayout);
    }
}
