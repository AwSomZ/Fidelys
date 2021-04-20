package com.example.fidelyss;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>  {
    private Context context;
    String value;
    String depends;
    String color;
    String datee;
    String id;
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        transaction Transaction = listeTransaction.get(position);
        Date date = Transaction.getDate();
        SimpleDateFormat sdfm = new SimpleDateFormat("MMM");
        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfd = new SimpleDateFormat("dd");
        String month =sdfm.format(date);

        System.out.println("month"+date.toString());
        String day =sdfd.format(date);
        holder.month.setText(month);
        holder.day.setText(day);

        if (Transaction.getDebit()==0)
            {
            holder.value.setText("+"+String.valueOf(Transaction.getCredit()));
            holder.depends.setText("Crédit");
            depends="crédit";
            value="+"+String.valueOf(Transaction.getCredit());
            holder.value.setTextColor(this.context.getResources().getColor(R.color.green));
            holder.background.setBackground(ContextCompat.getDrawable(context, R.drawable.cardgreen));
            color = "green";

            }
        else
            {
                holder.value.setText("-"+String.valueOf(Transaction.getDebit()));
                holder.depends.setText("Débit");
                holder.value.setTextColor(this.context.getResources().getColor(R.color.red));
                holder.background.setBackground(ContextCompat.getDrawable(context, R.drawable.cardred));
                depends="débit";
                value="-"+String.valueOf(Transaction.getDebit());
                color= "red";


            }

        holder.cd.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v)
        {
            Date date = Transaction.getDate();
            id= String.valueOf(Transaction.getId());
            datee= sdft.format(date);
            if (Transaction.getDebit()==0)
            {

                depends="crédit";
                value="+"+String.valueOf(Transaction.getCredit());
                color = "green";

            }
            else
            {

                depends="débit";
                value="-"+String.valueOf(Transaction.getDebit());
                color= "red";


            }

            Intent intent = new Intent(context, TransacationPopup.class);
            editor.putString("ref",id);
            editor.putString("value",value);
            editor.putString("depends",depends);
            editor.putString("datee",datee);
            editor.putString("color",color);
            editor.commit();

            context.startActivity(intent);

        }});



        };



    public int getItemCount() {
        return this.listeTransaction.size();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {

        TextView depends;
        TextView month;
        TextView value;
        CardView cd;
        ConstraintLayout background;
        TextView day;


        public TransactionViewHolder(View itemView) {
            super(itemView);

            depends = (TextView)itemView.findViewById(R.id.depends);
            background = (ConstraintLayout) itemView.findViewById(R.id.view);
            cd = (CardView) itemView.findViewById(R.id.cd);
            value = (TextView)itemView.findViewById(R.id.valeur);
            day = (TextView)itemView.findViewById(R.id.day);
            month = (TextView)itemView.findViewById(R.id.month);




        }
    }
}