package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class NewExpenses extends AppCompatActivity {

    ImageButton submitBtn;
    EditText descText,paymentMode,totalCost,litre,notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expenses);

        submitBtn=findViewById(R.id.submitBtn);
        descText=findViewById(R.id.descText);
        paymentMode=findViewById(R.id.paymentMode);
        totalCost=findViewById(R.id.totalCost);
        litre=findViewById(R.id.litre);
        notes=findViewById(R.id.notes);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(NewExpenses.this, Expenses.class);
                startActivity(a);
            }
        });
    }
}
