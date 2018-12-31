package com.example.anass.festivalapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Repositories.FestivalRepository;

import java.util.List;

public class FestivalViewModel extends AndroidViewModel {

    private FestivalRepository repository;
    private LiveData<List<Festival>> allFestivals;

    public FestivalViewModel(@NonNull Application application) {
        super(application);
        repository = new FestivalRepository(application);
        allFestivals = repository.getAllFestivals();
    }

    public void insert(Festival festival){
        repository.insert(festival);
    }

    public void update(Festival festival){
        repository.update(festival);
    }

    public void delete(Festival festival){
        repository.delete(festival);
    }

    public LiveData<List<Festival>> getAllFestivals() {
        return allFestivals;
    }
}
