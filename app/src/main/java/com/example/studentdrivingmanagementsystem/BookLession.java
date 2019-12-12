package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class BookLession extends AppCompatActivity {

    TextView time;
    ImageButton newAppoint;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lession);

        time = findViewById(R.id.time);
        newAppoint = findViewById(R.id.confirmBookingBtn);
        calendar = findViewById(R.id.calendarView);


        newAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(BookLession.this, calendar.class);
                startActivity(a);
            }
        });


    }
}
