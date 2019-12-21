package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class calendar extends AppCompatActivity {

    EditText calendartimeSelect;
    ImageButton confirmAppointBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendartimeSelect = findViewById(R.id.calendartimeSelect);
        confirmAppointBtn = findViewById(R.id.confirmAppointBtn);


        confirmAppointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(calendar.this, BookLession.class);
                startActivity(a);
            }
        });
    }
}
