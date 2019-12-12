package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class History extends AppCompatActivity {

    TextView dateOutput, nameOutput, appointmentOutput, timeOutput, notesOutput;
    EditText dateSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        dateOutput = findViewById(R.id.dateOutput);
        nameOutput = findViewById(R.id.nameOutput);
        appointmentOutput = findViewById(R.id.appointmentOutput);
        timeOutput = findViewById(R.id.timeOutput);
        notesOutput = findViewById(R.id.notesOutput);

        dateSelect = findViewById(R.id.dateSelect);

    }
}
