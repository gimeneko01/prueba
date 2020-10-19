package com.chiri.chiri.courseraagenda;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;


public class DateSetting implements DatePickerDialog.OnDateSetListener {
    Context context;
    public DateSetting (Context context){
        this.context=context;

    }
    @Override
    public void onDateSet(DatePicker view, int year, int dateSetting, int dayOfMonth) {
        Toast.makeText(context,"Selected date:"+dateSetting+"/"+dayOfMonth+"/"+year,Toast.LENGTH_LONG).show();

    }
}