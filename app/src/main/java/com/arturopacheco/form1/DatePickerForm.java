package com.arturopacheco.form1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.DatePicker;

/**
 * Created by arturopacheco on 03/04/17.
 */

public class DatePickerForm extends android.support.v4.app.DialogFragment implements DatePickerDialog.OnDateSetListener {

    TextInputEditText birthDateText;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int viewId = getArguments().getInt("viewId");

        //Obtenemos el View
        birthDateText = (TextInputEditText) getActivity().findViewById(viewId);

        int year = getArguments().getInt("year",1990);
        int month = getArguments().getInt("month",4);
        int day = getArguments().getInt("day",1);


        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        int realMonth = month +1;
        birthDateText.setText(dayOfMonth+"-"+realMonth+"-"+year);


    }
}
