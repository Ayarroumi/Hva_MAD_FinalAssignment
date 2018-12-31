package com.example.anass.festivalapp.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.User;
import com.example.anass.festivalapp.Entities.Wallet;

import java.util.List;

@Dao
public interface WalletDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Wallet wallet);

    @Update
    void update(Wallet wallet);

    @Delete
    void delete(Wallet wallet);

    @Query("SELECT * FROM wallets WHERE userId == :id")
    Wallet getWallet(int id);

}

