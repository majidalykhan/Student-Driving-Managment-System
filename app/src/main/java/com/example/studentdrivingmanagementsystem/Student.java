package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Student extends AppCompatActivity {


    ImageButton calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/java/com/example/studentdrivingmanagementsystem/Student.java
        setContentView(R.layout.activity_student);
=======
        setContentView(R.layout.activity_main);


        calendar = findViewById(R.id.calendarBtn);


        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, BookLession.class);
                startActivity(a);
            }
        });

>>>>>>> 8e85dd0e356571640d84153cb24d863a2bc0a6d4:app/src/main/java/com/example/studentdrivingmanagementsystem/MainActivity.java
    }
}
