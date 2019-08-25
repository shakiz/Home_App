package com.shakil.homeapp.activities.utils;

import android.view.View;
import android.widget.EditText;

public class InputValidation {
    public boolean checkEditTextInput(int resIdArray, String message, View view){
        EditText editText = view.findViewById(resIdArray);
        if (editText.getText().toString().isEmpty()){
            editText.setError(message);
            return false;
        }
        else{
            return true;
        }
    }
}
