package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Expenses extends AppCompatActivity {

    ImageButton newexpensefuelbtn,newexpensevehiclebtn,newexpenseotherbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        newexpensefuelbtn=findViewById(R.id.newexpensefuelbtn);
        newexpensevehiclebtn=findViewById(R.id.newexpensevehiclebtn);
        newexpenseotherbtn=findViewById(R.id.newexpenseotherbtn);

        newexpensefuelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Expenses.this, NewExpenses.class);
                startActivity(a);
            }
        });
        newexpensevehiclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Expenses.this, NewExpenses.class);
                startActivity(a);
            }
        });
        newexpenseotherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Expenses.this, NewExpenses.class);
                startActivity(a);
            }
        });
    }
}
