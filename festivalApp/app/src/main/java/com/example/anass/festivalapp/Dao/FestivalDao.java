package com.example.anass.festivalapp.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anass.festivalapp.Entities.Festival;

import java.util.List;

@Dao
public interface FestivalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Festival festival);

    @Update
    void update(Festival festival);

    @Delete
    void delete(Festival festival);

    @Query("SELECT * FROM FESTIVALS WHERE id == :id")
    Festival getFestival(int id);

    @Query("SELECT * FROM FESTIVALS")
    LiveData<List<Festival>> getAllFestivals();

}
