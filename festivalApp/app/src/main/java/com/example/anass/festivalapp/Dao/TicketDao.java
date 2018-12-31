package com.example.anass.festivalapp.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Ticket;

import java.util.List;

@Dao
public interface TicketDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Ticket ticket);

    @Update
    void update(Ticket ticket);

    @Delete
    void delete(Ticket ticket);

    @Query("SELECT * FROM TICKETS")
    LiveData<List<Ticket>> getAllTickets();

}
