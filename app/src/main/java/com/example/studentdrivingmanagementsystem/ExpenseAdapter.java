package com.example.studentdrivingmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {
    private Context mCtx;
    private List<ExpenseData> expenseList;

    public ExpenseAdapter(Context mCtx, List<ExpenseData> expenseList){
        this.mCtx = mCtx;
        this.expenseList = expenseList;
    }


    @NonNull
    @Override
    public ExpenseAdapter.ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExpenseViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.expenses_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ExpenseViewHolder holder, int position) {
        ExpenseData expenseD = expenseList.get(position);

        holder.desc.setText(expenseD.getDescr());
        holder.date.setText(expenseD.getdateBtn());
        holder.type.setText(expenseD.getExpensetype());
        holder.amount.setText(expenseD.getTotalcost());
        holder.notes.setText(expenseD.getNotes());

    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder{
        TextView desc, date, type, amount, notes;

        public ExpenseViewHolder(View itemView){
            super(itemView);

            desc = itemView.findViewById(R.id.descriptionExpense);
            date = itemView.findViewById(R.id.dateExpense);
            type = itemView.findViewById(R.id.typeExpense);
            amount = itemView.findViewById(R.id.amountExpense);
            notes = itemView.findViewById(R.id.notesExpense);

        }
    }
}
