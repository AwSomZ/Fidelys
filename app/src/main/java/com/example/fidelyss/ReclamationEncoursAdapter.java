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

public class ReclamationEncoursAdapter  extends RecyclerView.Adapter<ReclamationEncoursAdapter.ReclamationEncoursViewHolder>   {
    private Context context;
    Activity activity = (Activity) context;

    List<reclamation> listeReclamationEncours;

    public ReclamationEncoursAdapter(Context context, List<reclamation> listeReclamationEncours) {
        this.context = context;
        activity = (Activity) context;
        this.listeReclamationEncours = listeReclamationEncours;
    }

    @NonNull
    @Override
    public ReclamationEncoursAdapter.ReclamationEncoursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.recyclerviewreclamationencours),parent, false);
        ReclamationEncoursAdapter.ReclamationEncoursViewHolder UViewHolder = new ReclamationEncoursAdapter.ReclamationEncoursViewHolder(view);
        return UViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReclamationEncoursAdapter.ReclamationEncoursViewHolder holder, int position) {
        reclamation reclamation = listeReclamationEncours.get(position);
        Date datecreation = reclamation.getDatecreation();
        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdft.format(datecreation);
        holder.date.setText(date);
        holder.titre.setText(reclamation.getTitre());
    }

    @Override
    public int getItemCount() {
        return this.listeReclamationEncours.size();

    }
    public static class ReclamationEncoursViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView titre;

        ConstraintLayout background;


        public ReclamationEncoursViewHolder(View itemView) {
            super(itemView);

            date = (TextView) itemView.findViewById(R.id.datecreation);
            titre = (TextView) itemView.findViewById(R.id.titre);



        }
    }
}
