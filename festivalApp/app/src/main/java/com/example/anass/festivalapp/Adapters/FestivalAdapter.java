package com.example.anass.festivalapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewHolders.FestivalViewHolder;

import java.util.List;

public class FestivalAdapter extends RecyclerView.Adapter<FestivalViewHolder>{

    private Context context;
    public List<Festival> listFestivals;


    public FestivalAdapter(Context context, List<Festival> listFestivals) {
        this.context = context;
        this.listFestivals = listFestivals;
        this.context = context;
    }

    @NonNull
    @Override
    public FestivalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_grid_festival, viewGroup, false);
        return new FestivalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FestivalViewHolder festivalViewHolder, int i) {
        final Festival festival = listFestivals.get(i);

        festivalViewHolder.festivalName.setText(festival.getName());
        festivalViewHolder.festivalPrice.setText(festival.getPrice());
    }

    @Override
    public int getItemCount() {
        return listFestivals.size();
    }
}
