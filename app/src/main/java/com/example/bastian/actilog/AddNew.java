package com.example.bastian.actilog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


import android.text.format.DateFormat;
import java.util.Calendar;

public class AddNew extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    Button pickStart;
    TextView displayStart;

    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        pickStart = (Button) findViewById(R.id.pickStart);
        displayStart = (TextView) findViewById(R.id.displayStart);

        pickStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddNew.this, AddNew.this,
                        year, month, day);
                datePickerDialog.show();

            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get (Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(AddNew.this, AddNew.this,
                hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
hourFinal = i;
minuteFinal = i1;

displayStart.setText("year: " + yearFinal + "\n" +
        "month: " + monthFinal + "\n"+
        "day: " + dayFinal + "\n"+
        "hour: " + hourFinal + "\n"+
        "minute: " + minuteFinal);

    }
}
