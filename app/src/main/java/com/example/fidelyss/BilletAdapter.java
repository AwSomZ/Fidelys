package com.example.fidelyss;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BilletAdapter extends RecyclerView.Adapter<BilletAdapter.BilletViewHolder>   {
    private Context context;
    Activity activity = (Activity) context;
    List<billet> listeBillet;
    private static final Map<String, String> aka = new HashMap<String, String>() {{
        put("Abidjan","ABJ");
        put("Alger","ALG");
        put("Amsterdam","AMS");
        put("Bâle","BSL");
        put("Bamako","BKO");
        put("Barcelone","BCN");
        put("Belgrade","BEG");
        put("Benghazi","BEN");
        put("Berlin","SXF");
        put("Beyrouth","BEY");
        put("Bologne","BLQ");
        put("Bordeaux","BOD");
        put("Bruxelles","BRU");
        put("Casablanca","CMN");
        put("Conakry","CKY");
        put("Constantine","CZL");
        put("Cotonou","COO");
        put("Dakar","DSS");
        put("Djerba","DJE");
        put("Duesseldorf","DUS");
        put("Enfidha","NBE");
        put("Frankfurt","FRA");
        put("Gabes","GAB");
        put("Gafsa","GAF");
        put("Genève","GVA");
        put("Hamburg","HAM");
        put("Istanbul","IST");
        put("Jeddah","JED");
        put("Le Caire","CAI");
        put("Lille","LIL");
        put("Lisbonne","LIS");
        put("Londres","LON");
        put("Lyon","LYS");
        put("Madrid","MAD");
        put("Malte","MLA");
        put("Marseille","MRS");
        put("Médine","MED");
        put("Milan","MXP");
        put("Monastir","MIR");
        put("Montréal","YUL");
        put("Munich","MUC");
        put("Nantes","NTE");
        put("Naples","NAP");
        put("Niamey","NIM");
        put("Nice","NCE");
        put("Nouakchott","NKC");
        put("Oran","ORN");
        put("Ouagadougou","OUA");
        put("Palerme","PMO");
        put("Paris","PAR");
        put("Prague","PRG");
        put("Rome","FCO");
        put("Sfax","SFA");
        put("Strasbourg","SXB");
        put("Tabarka","TBJ");
        put("Toulouse","TLS");
        put("Tozeur","TOE");
        put("Tripoli","MJI");
        put("Tunis","TUN");
        put("Venise","VCE");
        put("Vérone","VRN");
        put("Vienne","VIE");
        put("Zurich","ZRH");
    }};

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
        Date dateretour = billet.getDateretour();
        String deString = billet.getDepart();
        String versString = billet.getDestination();
        System.out.println("top"+deString);
        String typeString = billet.getType();
        String classeString = billet.getClasse();
        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
        String dateallerString = sdft.format(datealler);
        String dateretourString = sdft.format(dateretour);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        LinearLayout.LayoutParams no = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 95, 0, 0);
        no.setMargins(0, 8, 0, 0);

        holder.datea.setText(dateallerString);
        if (typeString.equals("Aller simple"))
        {
            holder.dater.setVisibility(View.GONE);
            holder.arrow.setVisibility(View.GONE);
            holder.datea.setLayoutParams(params);
        }
        else {
            holder.dater.setVisibility(View.VISIBLE);
            holder.arrow.setVisibility(View.VISIBLE);
            holder.dater.setText(dateretourString);
            holder.datea.setLayoutParams(no);
        }
        holder.de.setText(aka.get(deString));
        holder.vers.setText(aka.get(versString));
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
        ImageView arrow;
        TextView classe;

        ConstraintLayout background;


        public BilletViewHolder(View itemView) {
            super(itemView);

            datea = (TextView) itemView.findViewById(R.id.datealler);
            arrow = (ImageView) itemView.findViewById(R.id.arrow);
            dater = (TextView) itemView.findViewById(R.id.dateretour);
            de = (TextView) itemView.findViewById(R.id.de);
            vers = (TextView) itemView.findViewById(R.id.vers);
            classe= (TextView) itemView.findViewById(R.id.classe);
            type = (TextView) itemView.findViewById(R.id.type);



        }
    }
}
