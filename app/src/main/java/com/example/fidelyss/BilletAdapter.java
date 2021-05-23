package com.example.fidelyss;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BilletAdapter extends RecyclerView.Adapter<BilletAdapter.BilletViewHolder>   {
    private Context context;
    Activity activity = (Activity) context;

    List<billet> listeBillet;

    public BilletAdapter(Context context, List<billet> listeBillet) {
        this.context = context;
        activity = (Activity) context;
        this.listeBillet = listeBillet;
    }

    @NonNull
    @Override
    public BilletAdapter.BilletViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.recyclerviewbillet),parent, false);
        BilletAdapter.BilletViewHolder UViewHolder = new BilletAdapter.BilletViewHolder(view);
        return UViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BilletAdapter.BilletViewHolder holder, int position) {
        billet billet = listeBillet.get(position);
        Date datealler = billet.getDatealler();
        Date dateretour = billet.getDatealler();
        String deString = billet.getDe();
        String versString = billet.getVers();
        String typeString = billet.getType();
        String classeString = billet.getClasse();
        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
        String dateallerString = sdft.format(datealler);
        String dateretourString = sdft.format(dateretour);
        holder.datea.setText(dateallerString);
        holder.dater.setText(dateretourString);
        holder.de.setText(deString);
        holder.vers.setText(versString);
        holder.type.setText(typeString);
        holder.classe.setText(classeString);

    }

    @Override
    public int getItemCount() {
        return this.listeBillet.size();

    }
    public static class BilletViewHolder extends RecyclerView.ViewHolder {

        TextView datea;
        TextView dater;
        TextView de;
        TextView vers;
        TextView type;
        TextView classe;

        ConstraintLayout background;


        public BilletViewHolder(View itemView) {
            super(itemView);

            datea = (TextView) itemView.findViewById(R.id.datealler);
            dater = (TextView) itemView.findViewById(R.id.dateretour);
            de = (TextView) itemView.findViewById(R.id.de);
            vers = (TextView) itemView.findViewById(R.id.vers);
            classe= (TextView) itemView.findViewById(R.id.classe);
            type = (TextView) itemView.findViewById(R.id.type);



        }
    }
}
