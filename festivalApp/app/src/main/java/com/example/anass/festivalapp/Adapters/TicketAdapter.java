package com.example.anass.festivalapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Ticket;
import com.example.anass.festivalapp.R;
import com.example.anass.festivalapp.ViewHolders.FestivalViewHolder;
import com.example.anass.festivalapp.ViewHolders.TicketViewHolder;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketViewHolder>{

    private Context context;
    public List<Ticket> listTickets;


    public TicketAdapter(Context context, List<Ticket> listTickets) {
        this.context = context;
        this.listTickets = listTickets;
        this.context = context;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_grid_ticket, viewGroup, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {
        final Ticket ticket = listTickets.get(i);

        ticketViewHolder.ticketName.setText(ticket.getName());
    }

    @Override
    public int getItemCount() {
        return listTickets.size();
    }
}
