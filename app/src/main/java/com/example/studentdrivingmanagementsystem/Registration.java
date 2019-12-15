package com.example.studentdrivingmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText studentNo, name, address, postalCode, email, mobileNo,
             drivingLicenseNo, medicalCondition, reference, note, editdate;
    CheckBox provisionalDrivingLicenseChkbox, theoryTestPassedChkbox, previousDrivingChkbox, eyesightChkbox;
    ImageButton uploadBtn , dateBtn, submitRegBtn;

    //EditText
    private static final String KEY_STUDENTNO = "student_no";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_POSTALCODE = "postalCode";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MOBILENO = "mobileNo";
    private static final String KEY_drivingLicenseNo = "drivingLicenseNo";
    private static final String KEY_medicalCondition = "medicalCondition";
    private static final String KEY_reference = "reference";
    private static final String KEY_note = "note";
    //CheckBoxes
    private static final String KEY_provisionalDrivingLicenseChkbox = "provisionalDrivingLicense";
    private static final String KEY_theoryTestPassedChkbox = "theoryTestPassed";
    private static final String KEY_previousDrivingChkbox = "previousDriving";
    private static final String KEY_eyesightChkbox = "eyesight";
    //date
    private static final String KEY_date = "date";
    //Upload
    private static final String KEY_upload = "upload";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


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
        editdate = findViewById(R.id.editDate);


        provisionalDrivingLicenseChkbox = findViewById(R.id.provisionalDrivingLicenseChkbox);
        theoryTestPassedChkbox = findViewById(R.id.theoryTestPassedChkbox);
        previousDrivingChkbox = findViewById(R.id.previousDrivingChkbox);
        eyesightChkbox = findViewById(R.id.eyesightChkbox);

        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox1", false);
        provisionalDrivingLicenseChkbox.setChecked(checked);


        uploadBtn = findViewById(R.id.uploadBtn);
        dateBtn = findViewById(R.id.date);
        submitRegBtn = findViewById(R.id.submitRegBtn);


        //For Date Input
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel(){
                String myFormat = "dd-MM-yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editdate.setText(sdf.format(myCalendar.getTime()));
            }
        };

        dateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Registration.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        submitRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });


    }


    private void register(){

        String studentNum = studentNo.getText().toString();
        String studentName = name.getText().toString();
        String stuAddress = address.getText().toString();
        String stuPostalCode = postalCode.getText().toString();
        String stuEmail = email.getText().toString();
        String stuMobile = mobileNo.getText().toString();
        String stuLicenseNo = drivingLicenseNo.getText().toString();
        String stuMedical = medicalCondition.getText().toString();
        String stuReference = reference.getText().toString();
        String stuNote = note.getText().toString();
        String Date = editdate.getText().toString();

        Map<String, Object> student = new HashMap<>();

        student.put(KEY_STUDENTNO, studentNum);
        student.put(KEY_NAME, studentName);
        student.put(KEY_ADDRESS, stuAddress);
        student.put(KEY_POSTALCODE, stuPostalCode);
        student.put(KEY_EMAIL, stuEmail);
        student.put(KEY_MOBILENO, stuMobile);
        student.put(KEY_drivingLicenseNo, stuLicenseNo);
        student.put(KEY_medicalCondition, stuMedical);
        student.put(KEY_reference, stuReference);
        student.put(KEY_note, stuNote);
        student.put(KEY_date, Date);
        

       db.collection("students").document().set(student)
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


    private void SaveData(){
        String no = studentNo.getText().toString().trim();
        String Name = name.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String postal = postalCode.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String mobile = mobileNo.getText().toString().trim();
        String licenseNo = drivingLicenseNo.getText().toString().trim();
        String medical = medicalCondition.getText().toString().trim();
        String referenc = reference.getText().toString().trim();
        String Note = note.getText().toString().trim();
        String date = editdate.getText().toString().trim();


        CollectionReference studentsdb = db.collection("students");

        studentData student = new studentData(
                no, Name, Address, postal, Email, mobile, licenseNo, medical, referenc, Note, date
        ){};

        studentsdb.add(student).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Registration.this,"Register Successful",Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this,"Register Failed",Toast.LENGTH_LONG).show();

            }
        });

    }


}
