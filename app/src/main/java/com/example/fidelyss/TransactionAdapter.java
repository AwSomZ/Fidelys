package com.example.fidelyss;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private Context context;
    List<transaction> listeTransaction;

    public TransactionAdapter(Context context, List<transaction> listeTransaction) {
        this.context = context;
        this.listeTransaction = listeTransaction;
    }
    @NonNull
    @Override
public TransactionAdapter.TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.recyclerviewtransaction),parent, false);
        TransactionViewHolder UViewHolder = new TransactionViewHolder(view);
        return UViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final TransactionAdapter.TransactionViewHolder holder, final int position) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.context.getSharedPreferences("clientfidelys", Context.MODE_PRIVATE);
        String mile = sharedPreferences.getString("solde","");
        transaction Transaction = listeTransaction.get(position);
        Date date = Transaction.getDate();
        SimpleDateFormat sdfm = new SimpleDateFormat("MMM");
        SimpleDateFormat sdfd = new SimpleDateFormat("dd");
        String month =sdfm.format(date);
        System.out.println("month"+date.toString());
        String day =sdfd.format(date);
        holder.credit.setText(String.valueOf(Transaction.getCredit()));
        holder.debit.setText(String.valueOf(Transaction.getDebit()));
        holder.month.setText(month);
        holder.day.setText(day);




        };
    public int getItemCount() {
        return this.listeTransaction.size();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {

        TextView credit;
        TextView debit;
        TextView month;
        TextView day;


        public TransactionViewHolder(View itemView) {
            super(itemView);

            credit = (TextView)itemView.findViewById(R.id.credit);
            debit = (TextView)itemView.findViewById(R.id.debit);
            day = (TextView)itemView.findViewById(R.id.day);
            month = (TextView)itemView.findViewById(R.id.month);



        }
    }
}
