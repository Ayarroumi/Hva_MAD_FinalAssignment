package com.example.anass.festivalapp.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anass.festivalapp.Entities.Festival;
import com.example.anass.festivalapp.Entities.Transaction;
import com.example.anass.festivalapp.Entities.User;

import java.util.List;

@Dao
public interface UserDao {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(User user);

        @Update
        void update(User user);

        @Delete
        void delete(User user);

        @Query("SELECT * FROM USERS WHERE id == :id")
        LiveData<User> getUsers(int id);

        @Query("SELECT * FROM USERS WHERE id == :id")
        User getUser(int id);

    }

