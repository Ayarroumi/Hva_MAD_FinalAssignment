package com.example.anass.festivalapp.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anass.festivalapp.R;


public class FestivalViewHolder extends RecyclerView.ViewHolder {

    public ImageView festivalImage;
    public TextView festivalName;
    public TextView festivalPrice;

    public FestivalViewHolder(View itemView) {
        super(itemView);
        festivalImage = itemView.findViewById(R.id.festival_image);
        festivalName = itemView.findViewById(R.id.festival_name);
        festivalPrice = itemView.findViewById(R.id.festival_price);
    }


}