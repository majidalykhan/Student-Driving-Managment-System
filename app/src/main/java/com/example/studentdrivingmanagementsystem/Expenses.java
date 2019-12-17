package com.example.studentdrivingmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Expenses extends AppCompatActivity {

    ImageButton newexpenseotherbtn;

    FirebaseFirestore db;
    RecyclerView recyclerView;
    List<ExpenseData> expenseList;
    ExpenseAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        newexpenseotherbtn=findViewById(R.id.newexpenseotherbtn);

        recyclerView = findViewById(R.id.expenseRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        expenseList = new ArrayList<>();
        adapter = new ExpenseAdapter(this,expenseList);

        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        Read();


        newexpenseotherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Expenses.this, NewExpenses.class);
                startActivity(a);
            }
        });
    }

    private void Read(){

        db.collection("expenses").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty()){
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                            for (DocumentSnapshot d: list){
                                ExpenseData e = d.toObject(ExpenseData.class);
                                expenseList.add(e);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

    }
}
