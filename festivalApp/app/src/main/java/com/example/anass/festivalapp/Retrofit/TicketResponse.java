package com.example.anass.festivalapp.Retrofit;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Ticket;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TicketResponse {
    @SerializedName("tickets")
    @Expose
    ArrayList<Ticket> tickets;

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}

