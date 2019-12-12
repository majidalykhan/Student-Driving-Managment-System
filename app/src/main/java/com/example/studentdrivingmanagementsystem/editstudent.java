package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class editstudent extends AppCompatActivity {

    ImageButton booklessonbtn;
    EditText editname,editnextlesson,editmobile,editlicenseno,edittotalprice,edithourrate,editdiscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editstudent);

        editname=findViewById(R.id.editname);
        editdiscount=findViewById(R.id.editdiscount);
        editnextlesson=findViewById(R.id.editnextlesson);
        editmobile=findViewById(R.id.editmobile);
        editlicenseno=findViewById(R.id.editlicenseno);
        edittotalprice=findViewById(R.id.edittotalprice);
        edithourrate=findViewById(R.id.edithourrate);
        booklessonbtn = findViewById(R.id.booklessonbtn);

        booklessonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(editstudent.this, student.class);
                startActivity(a);
            }
        });

    }
}
