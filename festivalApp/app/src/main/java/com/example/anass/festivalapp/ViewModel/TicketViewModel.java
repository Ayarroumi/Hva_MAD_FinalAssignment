package com.example.anass.festivalapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Ticket;
import com.example.anass.festivalapp.Repositories.FestivalRepository;
import com.example.anass.festivalapp.Repositories.TicketRepository;

import java.util.List;

public class TicketViewModel extends AndroidViewModel {

    private TicketRepository repository;
    private LiveData<List<Ticket>> allTickets;

    public TicketViewModel(@NonNull Application application) {
        super(application);
        repository = new TicketRepository(application);
        allTickets = repository.getAllTickets();
    }

    public void insert(Ticket ticket){
        repository.insert(ticket);
    }

    public void update(Ticket ticket){
        repository.update(ticket);
    }

    public void delete(Ticket ticket){
        repository.delete(ticket);
    }

    public LiveData<List<Ticket>> getAllTickets() {
        return allTickets;
    }
}
