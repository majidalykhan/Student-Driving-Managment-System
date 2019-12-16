package com.example.studentdrivingmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RegisteredStudents extends AppCompatActivity {

    private static final String TAG = "FireLog";
    TextView nam, mob;
    private static final String KEY_NAME = "name";
    private static final String KEY_MOBILE = "mobile";

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    CollectionReference std = firebaseFirestore.collection("students");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_students);

        firebaseFirestore = FirebaseFirestore.getInstance();
        nam = findViewById(R.id.names);

        Load();

    }

    private void Load(){
       std.get()
               .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                   @Override
                   public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                       String data = "";
                       String line = "-----------------";


                       for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                           studentData studentData = documentSnapshot.toObject(com.example.studentdrivingmanagementsystem.studentData.class);
                           String names = studentData.getName();
                           String num = studentData.getMobile();

                           data += "Name : " + names + "\n" + "Mobile : " + num + "\n"
                                   + "--------------------------------------------------" +
                                   "\n";

                           //data2 += "Mobile : " + num + "\n";


                       }
                       nam.setText(data);

                   }
               });
    }

}
