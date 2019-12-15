package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    ImageButton whatsapp,smsbtn,callbtn;
    TextView settingstdcontactnoOutput,settingstdnameOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        whatsapp=findViewById(R.id.whatsapp);
        smsbtn=findViewById(R.id.smsbtn);
        callbtn=findViewById(R.id.callbtn);
        settingstdcontactnoOutput=findViewById(R.id.settingstdcontactnoOutput);
        settingstdnameOutput=findViewById(R.id.settingstdnameOutput);





    }
}
