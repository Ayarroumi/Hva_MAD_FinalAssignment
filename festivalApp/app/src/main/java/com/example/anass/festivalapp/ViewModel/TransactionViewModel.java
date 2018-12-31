package com.example.anass.festivalapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Fragments.MyTicketFragment;
import com.example.anass.festivalapp.Repositories.FestivalRepository;
import com.example.anass.festivalapp.Repositories.TransactionRepository;

import java.util.List;

public class TransactionViewModel extends AndroidViewModel {

    private TransactionRepository repository;
    private LiveData<List<Transaction>> allTransactions;

    public TransactionViewModel(@NonNull Application application) {
        super(application);
        repository = new TransactionRepository(application);
    }


    public void insert(Transaction transaction){
        repository.insert(transaction);
    }

    public void update(Transaction transaction){
        repository.update(transaction);
    }

    public void delete(Transaction transaction){
        repository.delete(transaction);
    }

    public LiveData<List<Transaction>> getAllTransactions(int id) {
        return repository.getAllTransactions(id);
    }
}
