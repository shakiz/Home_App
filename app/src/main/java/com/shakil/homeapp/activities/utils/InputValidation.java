package com.shakil.homeapp.activities.utils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;

public class InputValidation {
    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

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

    public boolean checkEditTextInput(int[] resIdArray, String message, View view){
        boolean validation = false;
        for(int start = 0;start < resIdArray.length;start++){
            EditText editText = view.findViewById(resIdArray[start]);
            if (editText.getText().toString().isEmpty()){
                editText.setError(message);
                validation = false;
            }
            else{
                validation = true;
            }
        }
        return validation;
    }

    public boolean checkTextInputEditTextInput(int resIdArray, String message, View view){
        TextInputEditText editText = view.findViewById(resIdArray);
        if (editText.getText().toString().isEmpty()){
            editText.setError(message);
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkTextInputEditTextInput(int[] resIdArray, String message, View view){
        boolean validation = false;
        for(int start = 0;start < resIdArray.length;start++){
            TextInputEditText editText = view.findViewById(resIdArray[start]);
            if (editText.getText().toString().isEmpty()){
                editText.setError(message);
                return false;
            }
            else{
                return true;
            }
        }
        return validation;
    }
}
