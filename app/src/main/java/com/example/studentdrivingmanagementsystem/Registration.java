package com.example.studentdrivingmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText studentNo, name, address, postalCode, email, mobileNo,
             drivingLicenseNo, medicalCondition, reference, note;
    CheckBox provisionalDrivingLicenseChkbox, theoryTestPassedChkbox, previousDrivingChkbox, eyesightChkbox;
    ImageButton uploadBtn , date, submitRegBtn;


    private static final String KEY_STUDENTNO = "student_no";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_POSTALCODE = "postalCode";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MOBILENO = "mobileNo";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();


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


        submitRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }


    private void register(){

        String studentNum = studentNo.getText().toString();
        String studentName = name.getText().toString();

        Map<String, Object> student = new HashMap<>();
        student.put(KEY_STUDENTNO, studentNum);
        student.put(KEY_NAME, studentName);

        db.collection("test").document("test student").set(student)
        .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Registration.this,"Register Successful",Toast.LENGTH_LONG).show();

            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this,"Register Failed",Toast.LENGTH_LONG).show();

            }
        });

    }

}
