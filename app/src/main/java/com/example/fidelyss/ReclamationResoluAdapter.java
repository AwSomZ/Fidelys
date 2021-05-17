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

public class ReclamationResoluAdapter  extends RecyclerView.Adapter<ReclamationResoluAdapter.ReclamationResoluViewHolder>   {
    private Context context;
    Activity activity = (Activity) context;

    List<reclamation> listeReclamationResolu;

    public ReclamationResoluAdapter(Context context, List<reclamation> listeReclamationResolu) {
        this.context = context;
        activity = (Activity) context;
        this.listeReclamationResolu = listeReclamationResolu;
    }

    @NonNull
    @Override
    public ReclamationResoluAdapter.ReclamationResoluViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.recyclerviewreclamtionresolu),parent, false);
        ReclamationResoluAdapter.ReclamationResoluViewHolder UViewHolder = new ReclamationResoluAdapter.ReclamationResoluViewHolder(view);
        return UViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReclamationResoluAdapter.ReclamationResoluViewHolder holder, int position) {
        reclamation reclamation = listeReclamationResolu.get(position);
        Date datecreation = reclamation.getDatecreation();
        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdft.format(datecreation);
        holder.date.setText(date);
        holder.titre.setText(reclamation.getTitre());
    }

    @Override
    public int getItemCount() {
        return this.listeReclamationResolu.size();

    }
    public static class ReclamationResoluViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView titre;

        ConstraintLayout background;


        public ReclamationResoluViewHolder(View itemView) {
            super(itemView);

            date = (TextView) itemView.findViewById(R.id.datecreation);
            titre = (TextView) itemView.findViewById(R.id.titre);



        }
    }
}
