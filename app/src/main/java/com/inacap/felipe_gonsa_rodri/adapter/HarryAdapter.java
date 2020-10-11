package com.inacap.felipe_gonsa_rodri.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.inacap.felipe_gonsa_rodri.R;

import java.util.List;

import com.inacap.felipe_gonsa_rodri.model.HarryPotter;

import de.hdodenhof.circleimageview.CircleImageView;

public class HarryAdapter extends RecyclerView.Adapter<HarryAdapter.HarryHolder> {

    public List<HarryPotter> list;
    public Activity activity;
    public int layout;


    public HarryAdapter(Activity activity, List<HarryPotter> list, int layout) {
        this.list = list;
        this.activity = activity;
        this.layout = layout;
    }




    @NonNull
    @Override
    public HarryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new HarryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HarryHolder holder, int position) {

        HarryPotter harry = list.get(position);

         holder.nameHarry.setText(harry.name);
            holder.speciesHarry.setText(harry.species);
            holder.genderHarry.setText(harry.gender);
            Glide.with(activity).load(harry.image).into(holder.harryCircleImg);
        holder.url_image = harry.image;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class HarryHolder extends RecyclerView.ViewHolder {

       CircleImageView harryCircleImg;
       TextView nameHarry;
       TextView speciesHarry;
       TextView genderHarry;

        RelativeLayout item_card;
        String url_image;

        public HarryHolder(@NonNull View itemView) {
            super(itemView);

            harryCircleImg = itemView.findViewById(R.id.harrycircleimg);
            nameHarry    = itemView.findViewById(R.id.nameharry);
            speciesHarry   = itemView.findViewById(R.id.speciesharry);
            genderHarry    = itemView.findViewById(R.id.genderharry);

            item_card      = itemView.findViewById(R.id.item_card);



        }//end constructor

    }//end HarryHolder

}//end HarryAdapter
