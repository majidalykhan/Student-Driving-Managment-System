package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;

public class BookLession extends AppCompatActivity {

    EditText timeSelect;
    ImageButton newAppoint;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lession);

        timeSelect = findViewById(R.id.timeSelect);
        newAppoint = findViewById(R.id.confirmBookingBtn);
        calendar = findViewById(R.id.calendarView);


        timeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        newAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(BookLession.this, calendar.class);
                startActivity(a);
            }
        });


    }
}
