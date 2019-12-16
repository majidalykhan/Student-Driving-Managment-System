package com.example.studentdrivingmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private Context mCtx;
    private List<studentData> studentList;

    public StudentAdapter(Context mCtx, List<studentData> studentList){
        this.mCtx = mCtx;
        this.studentList = studentList;
    }


    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.activity_student_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
        studentData studentD = studentList.get(position);

        holder.nam.setText(studentD.getName());
        holder.mob.setText(studentD.getMobile());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nam, mob;

        public StudentViewHolder(View itemView){
            super(itemView);

            nam = itemView.findViewById(R.id.stdnameOutput);
            mob = itemView.findViewById(R.id.stdcontactnoOutput);
        }
    }
}

