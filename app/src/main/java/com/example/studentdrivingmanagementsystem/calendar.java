package com.example.studentdrivingmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class calendar extends AppCompatActivity {


    ImageButton confirmAppointBtn,dateBtnapp;
    EditText calendartimeSelect,editdateexpenseapp;

    TextView calendarnewbtnselectTimeText;

    private static final String KEY_DATEBTNAPP = "dateBtnapp";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        confirmAppointBtn = findViewById(R.id.confirmAppointBtn);
        calendartimeSelect=findViewById(R.id.calendartimeSelect);
        calendarnewbtnselectTimeText=findViewById(R.id.calendarnewbtnselectTimeText);
        dateBtnapp=findViewById(R.id.dateBtnapp);
        editdateexpenseapp=findViewById(R.id.editdateexpenseapp);



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

            private void updateLabel() {
                String myFormat = "dd-MM-yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editdateexpenseapp.setText(sdf.format(myCalendar.getTime()));
            }
        };


        dateBtnapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(calendar.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        confirmAppointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addappointmentfirebase();

                Intent a = new Intent(calendar.this, BookLession.class);
                startActivity(a);
            }
        });

    }



    private void addappointmentfirebase() {
        //String id= Id.getText().toString().trim();
        String dateBtnapp = editdateexpenseapp.getText().toString().trim();

        CollectionReference appdatadb = db.collection("AddAppointmentData");
        AppointmentData appointment = new AppointmentData(dateBtnapp) {};

        appdatadb.add(appointment).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(calendar.this, "Appointment Booked Successful", Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(calendar.this, "Appointment Booked Failed", Toast.LENGTH_LONG).show();

            }
        });


    }
}
