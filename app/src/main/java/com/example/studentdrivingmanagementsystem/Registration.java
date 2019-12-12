package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

public class Registration extends AppCompatActivity {

    EditText studentNo, name, address, postalCode, email, mobileNo,
             drivingLicenseNo, medicalCondition, reference, note;
    CheckBox provisionalDrivingLicenseChkbox, theoryTestPassedChkbox, previousDrivingChkbox, eyesightChkbox;
    ImageButton uploadBtn , date, submitRegBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        studentNo = findViewById(R.id.studentNo);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        postalCode = findViewById(R.id.postalCode);
        email = findViewById(R.id.email);
        mobileNo = findViewById(R.id.mobileNo);
        drivingLicenseNo = findViewById(R.id.drivingLicenseNo);
        medicalCondition = findViewById(R.id.medicalCondition);
        reference = findViewById(R.id.reference);
        note = findViewById(R.id.note);

        provisionalDrivingLicenseChkbox = findViewById(R.id.provisionalDrivingLicenseChkbox);
        theoryTestPassedChkbox = findViewById(R.id.theoryTestPassedChkbox);
        previousDrivingChkbox = findViewById(R.id.previousDrivingChkbox);
        eyesightChkbox = findViewById(R.id.eyesightChkbox);

        uploadBtn = findViewById(R.id.uploadBtn);
        date = findViewById(R.id.date);
        submitRegBtn = findViewById(R.id.submitRegBtn);


    }
}
