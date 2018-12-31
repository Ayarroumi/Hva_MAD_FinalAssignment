package com.example.anass.festivalapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.Fragments.MyTicketFragment;
import com.example.anass.festivalapp.Repositories.FestivalRepository;
import com.example.anass.festivalapp.Repositories.TransactionRepository;
import com.example.anass.festivalapp.Repositories.WalletRepository;

import java.util.List;

public class WalletViewModel extends AndroidViewModel {

    private WalletRepository repository;


    public WalletViewModel(@NonNull Application application) {
        super(application);
        repository = new WalletRepository(application);
    }

    public void insert(Wallet wallet){
        repository.insert(wallet);
    }

    public void update(Wallet wallet){
        repository.update(wallet);
    }

    public void delete(Wallet wallet){
        repository.delete(wallet);
    }

    public Wallet getWallet(int id){ return repository.getWallet(id);}
}
