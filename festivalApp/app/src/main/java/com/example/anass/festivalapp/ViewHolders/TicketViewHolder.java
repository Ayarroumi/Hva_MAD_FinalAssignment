package com.example.anass.festivalapp.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anass.festivalapp.R;


public class TicketViewHolder extends RecyclerView.ViewHolder {

    public TextView ticketName;

    public TicketViewHolder(View itemView) {
        super(itemView);
        ticketName = itemView.findViewById(R.id.ticket_name);
    }


}