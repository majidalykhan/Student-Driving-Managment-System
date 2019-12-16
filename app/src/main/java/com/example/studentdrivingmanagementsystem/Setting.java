package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    ImageButton whatsapp, smsbtn, callbtn;
    TextView settingstdcontactnoOutput, settingstdnameOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        whatsapp = findViewById(R.id.whatsapp);
        smsbtn = findViewById(R.id.smsbtn);
        callbtn = findViewById(R.id.callbtn);
        settingstdcontactnoOutput = findViewById(R.id.settingstdcontactnoOutput);
        settingstdnameOutput = findViewById(R.id.settingstdnameOutput);

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("smsto:" + "03105484207");
                Intent i=new Intent(Intent.ACTION_SENDTO,uri);
                i.setPackage("com.whatsapp");
                startActivity(i);
            }
        });
    }

    public void onDialButton(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:090078601"));
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
        startActivity(intent);
    }

}
