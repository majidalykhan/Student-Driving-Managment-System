package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TimePicker;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class calendar extends AppCompatActivity {

   // EditText calendartimeSelect;
    ImageButton confirmAppointBtn;
    TimePicker timeSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        timeSelect = findViewById(R.id.timeSelect);
        confirmAppointBtn = findViewById(R.id.confirmAppointBtn);

        timeSelect = (TimePicker) findViewById(R.id.timeSelect);
        timeSelect.setIs24HourView(false); // used to display AM/PM mode
        // perform set on time changed listener event
        timeSelect.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // display a toast with changed values of time picker
                Toast.makeText(getApplicationContext(), hourOfDay + "  " + minute, Toast.LENGTH_SHORT).show();

            }
        });
        confirmAppointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(calendar.this, BookLession.class);
                startActivity(a);
            }
        });
    }
}
