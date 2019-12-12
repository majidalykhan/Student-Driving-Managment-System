package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class student extends AppCompatActivity {

    ImageButton booklessonbtn,viewprogressbtn,editdetailsstudent;
    TextView name,nextlesson,mobile,licenseno,totalprice,hourrate,discount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        booklessonbtn=findViewById(R.id.booklessonbtn);
        viewprogressbtn=findViewById(R.id.viewprogressbtn);
        editdetailsstudent=findViewById(R.id.editdetailsstudent);
        name=findViewById(R.id.name);
        nextlesson=findViewById(R.id.nextlesson);
        mobile=findViewById(R.id.mobile);
        licenseno=findViewById(R.id.licenseno);
        totalprice=findViewById(R.id.totalprice);
        hourrate=findViewById(R.id.hourrate);
        discount=findViewById(R.id.discount);

        booklessonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(student.this, BookLession.class);
                startActivity(a);
            }
        });
        viewprogressbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(student.this, Progress.class);
                startActivity(a);
            }
        });
        editdetailsstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(student.this, editstudent.class);
                startActivity(a);
            }
        });
    }
}
