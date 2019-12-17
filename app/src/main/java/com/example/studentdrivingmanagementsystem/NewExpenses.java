package com.example.studentdrivingmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import io.opencensus.common.ServerStatsFieldEnums;

public class NewExpenses extends AppCompatActivity {

    ImageButton submitBtn, dateBtn;
    EditText description, paymentMode, totalCost, litre, notes, editdateexpense;
    Spinner spinnerexp;


    private static final String KEY_EXPENSETYPE = "expensetype";
    private static final String KEY_PAYMENTMODE = "paymentmode";
    private static final String KEY_TOTALCOST = "totalcost";
    private static final String KEY_LITRE = "litre";
    private static final String KEY_NOTES = "notes";
    private static final String KEY_DATEEXP = "dateBtn";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expenses);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        submitBtn = findViewById(R.id.submitBtn);
        description = findViewById(R.id.description);
        spinnerexp = findViewById(R.id.spinnerexp);
        paymentMode = findViewById(R.id.paymentMode);
        totalCost = findViewById(R.id.totalCost);
        litre = findViewById(R.id.litre);
        notes = findViewById(R.id.notes);
        dateBtn = findViewById(R.id.dateBtn);
        editdateexpense = findViewById(R.id.editdateexpense);





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

                editdateexpense.setText(sdf.format(myCalendar.getTime()));
            }
        };


        dateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(NewExpenses.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addexpense();

                Intent a = new Intent(NewExpenses.this, Expenses.class);
                startActivity(a);
            }
        });

    }

    private void addexpense() {
        //String id= Id.getText().toString().trim();
        String expensetype = spinnerexp.getSelectedItem().toString();
        String paymentmode = paymentMode.getText().toString().trim();
        String totalcost = totalCost.getText().toString().trim();
        String Litre = litre.getText().toString().trim();
        String Notes = notes.getText().toString().trim();
        String dateBtn = editdateexpense.getText().toString().trim();
        String descr = description.getText().toString().trim();

        CollectionReference expensedb = db.collection("expenses");
        ExpenseData expense = new ExpenseData(expensetype, paymentmode, totalcost, Litre, Notes, dateBtn, descr
        ) {};

        expensedb.add(expense).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(NewExpenses.this, "Expenses Add Successful", Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NewExpenses.this, "Expenses Submit Failed", Toast.LENGTH_LONG).show();

            }
        });


    }
}