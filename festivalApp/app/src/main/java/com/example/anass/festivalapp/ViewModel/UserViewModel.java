package com.example.anass.festivalapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;
import com.example.anass.festivalapp.Fragments.MyTicketFragment;
import com.example.anass.festivalapp.Repositories.FestivalRepository;
import com.example.anass.festivalapp.Repositories.TransactionRepository;
import com.example.anass.festivalapp.Repositories.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
    }


    public void insert(User user){
        repository.insert(user);
    }

    public void update(User user){
        repository.update(user);
    }

    public void delete(User user){
        repository.delete(user);
    }

    public User getUser(int id){ return repository.getUser(id);}
}
